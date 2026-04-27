package objektno2.fit.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_profile_seq")
    @SequenceGenerator(name = "user_profile_seq", sequenceName = "user_profile_seq", allocationSize = 1)
    private Long id;

    private String telefon;
    private String adresa;
    private String datumRodjenja;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UserProfile() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public String getAdresa() { return adresa; }
    public void setAdresa(String adresa) { this.adresa = adresa; }

    public String getDatumRodjenja() { return datumRodjenja; }
    public void setDatumRodjenja(String datumRodjenja) { this.datumRodjenja = datumRodjenja; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}