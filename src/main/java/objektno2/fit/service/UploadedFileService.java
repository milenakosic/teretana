package objektno2.fit.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import objektno2.fit.model.GrupniTrening;
import objektno2.fit.model.UploadedFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Dependent
public class UploadedFileService {

    @Inject
    EntityManager em;

    private static final String UPLOAD_DIR = "C:/uploads/";

    @Transactional
    public GrupniTrening uploadFile(Long grupniTreningId, String fileName, InputStream fileStream) {

        GrupniTrening trening = em.find(GrupniTrening.class, grupniTreningId);
        if (trening == null) {
            throw new RuntimeException("Grupni trening sa id=" + grupniTreningId + " nije pronađen!");
        }

        String filePath = UPLOAD_DIR + fileName;
        File destFile = new File(filePath);

        if (destFile.exists()) {
            throw new RuntimeException("Fajl sa imenom " + fileName + " već postoji!");
        }

        try {
            Files.createDirectories(Paths.get(UPLOAD_DIR));
            Files.copy(fileStream, destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Greška pri čuvanju fajla: " + e.getMessage());
        }

        UploadedFile uploadedFile = new UploadedFile();
        uploadedFile.setFilename(filePath);
        em.persist(uploadedFile);

        trening.getUploadedFiles().add(uploadedFile);
        return em.merge(trening);
    }

    @Transactional
    public GrupniTrening getTreningWithFiles(Long grupniTreningId) {
        GrupniTrening trening = em.find(GrupniTrening.class, grupniTreningId);
        if (trening == null) {
            throw new RuntimeException("Grupni trening sa id=" + grupniTreningId + " nije pronađen!");
        }

        trening.getUploadedFiles().forEach(uploadedFile -> {
            File file = new File(uploadedFile.getFilename());
            if (file.exists()) {
                uploadedFile.setFile(file);
            }
        });

        return trening;
    }
}