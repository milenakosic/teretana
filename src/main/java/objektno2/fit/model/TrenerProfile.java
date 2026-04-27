package objektno2.fit.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trener_profiles")
public class TrenerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trener_profile_seq")
    @SequenceGenerator(name = "trener_profile_seq", sequenceName = "trener_profile_seq", allocationSize = 1)
    private Long id;

    private String specijalnost;
    private String biografija;
    private int godineIskustva;

    @OneToOne
    @JoinColumn(name = "trener_id")
    private Trener trener;

    public TrenerProfile() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSpecijalnost() { return specijalnost; }
    public void setSpecijalnost(String specijalnost) { this.specijalnost = specijalnost; }

    public String getBiografija() { return biografija; }
    public void setBiografija(String biografija) { this.biografija = biografija; }

    public int getGodineIskustva() { return godineIskustva; }
    public void setGodineIskustva(int godineIskustva) { this.godineIskustva = godineIskustva; }

    public Trener getTrener() { return trener; }
    public void setTrener(Trener trener) { this.trener = trener; }
}