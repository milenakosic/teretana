package objektno2.fit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "treneri")
public class Trener {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trener_seq")
    @SequenceGenerator(name = "trener_seq", sequenceName = "trener_seq", allocationSize = 1)
    private Long id;

    private String ime;
    private String prezime;
    private String brojTelefona;

    @JsonIgnore
    @OneToOne(mappedBy = "trener", fetch = FetchType.LAZY)
    private TrenerProfile trenerProfile;

    @JsonIgnore
    @OneToMany(mappedBy = "trener", fetch = FetchType.LAZY)
    private List<GrupniTrening> grupniTreninzi = new ArrayList<>();

    public Trener() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIme() { return ime; }
    public void setIme(String ime) { this.ime = ime; }

    public String getPrezime() { return prezime; }
    public void setPrezime(String prezime) { this.prezime = prezime; }

    public String getBrojTelefona() { return brojTelefona; }
    public void setBrojTelefona(String brojTelefona) { this.brojTelefona = brojTelefona; }

    public TrenerProfile getTrenerProfile() { return trenerProfile; }
    public void setTrenerProfile(TrenerProfile trenerProfile) { this.trenerProfile = trenerProfile; }

    public List<GrupniTrening> getGrupniTreninzi() { return grupniTreninzi; }
    public void setGrupniTreninzi(List<GrupniTrening> grupniTreninzi) { this.grupniTreninzi = grupniTreninzi; }
}