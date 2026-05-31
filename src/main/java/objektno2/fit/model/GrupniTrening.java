package objektno2.fit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grupni_treninzi")
public class GrupniTrening {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupni_trening_seq")
    @SequenceGenerator(name = "grupni_trening_seq", sequenceName = "grupni_trening_seq", allocationSize = 1)
    private Long id;

    private String naziv;
    private int trajanje;
    private int maxMjesta;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trener_id")
    private Trener trener;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "grupni_trening_files",
            joinColumns = @JoinColumn(name = "grupni_trening_id"),
            inverseJoinColumns = @JoinColumn(name = "uploaded_file_id")
    )
    private List<UploadedFile> uploadedFiles = new ArrayList<>();

    public GrupniTrening() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }

    public int getTrajanje() { return trajanje; }
    public void setTrajanje(int trajanje) { this.trajanje = trajanje; }

    public int getMaxMjesta() { return maxMjesta; }
    public void setMaxMjesta(int maxMjesta) { this.maxMjesta = maxMjesta; }

    public Trener getTrener() { return trener; }
    public void setTrener(Trener trener) { this.trener = trener; }

    public List<UploadedFile> getUploadedFiles() { return uploadedFiles; }
    public void setUploadedFiles(List<UploadedFile> uploadedFiles) { this.uploadedFiles = uploadedFiles; }
}