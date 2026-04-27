package objektno2.fit.service;

import objektno2.fit.model.GrupniTrening;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@Dependent
public class GrupniTreningService {

    @Inject
    EntityManager em;

    @Transactional
    public GrupniTrening createGrupniTrening(GrupniTrening grupniTrening) {
        if (grupniTrening == null) {
            throw new RuntimeException("Grupni trening nije proslijeđen");
        }
        if (grupniTrening.getNaziv() == null || grupniTrening.getNaziv().isEmpty()) {
            throw new RuntimeException("Naziv je prazan");
        }
        em.persist(grupniTrening);
        return grupniTrening;
    }

    public List<GrupniTrening> getAllGrupniTreninzi() {
        return em.createQuery("SELECT g FROM GrupniTrening g", GrupniTrening.class)
                .getResultList();
    }

    public List<GrupniTrening> findByNaziv(String naziv) {
        List<GrupniTrening> treninzi = em.createQuery(
                        "SELECT g FROM GrupniTrening g WHERE g.naziv LIKE :naziv", GrupniTrening.class)
                .setParameter("naziv", "%" + naziv + "%")
                .getResultList();

        if (treninzi.isEmpty()) {
            throw new RuntimeException("Ne postoji trening sa nazivom: " + naziv);
        }
        return treninzi;
    }
}