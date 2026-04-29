package objektno2.fit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    private String ime;
    private String prezime;
    private String email;

    @JsonIgnore
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private UserProfile userProfile;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Membership> memberships = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private List<TimeApi> timeApiResponses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private List<CurrencyResponse> currencyResponses = new ArrayList<>();


    public User() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIme() { return ime; }
    public void setIme(String ime) { this.ime = ime; }

    public String getPrezime() { return prezime; }
    public void setPrezime(String prezime) { this.prezime = prezime; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<TimeApi> getTimeApiResponses() {
        return timeApiResponses;
    }

    public void setTimeApiResponses(List<TimeApi> timeApiResponses) {
        this.timeApiResponses = timeApiResponses;
    }

    public UserProfile getUserProfile() { return userProfile; }
    public void setUserProfile(UserProfile userProfile) { this.userProfile = userProfile; }

    public List<Membership> getMemberships() { return memberships; }
    public void setMemberships(List<Membership> memberships) { this.memberships = memberships; }

    public List<CurrencyResponse> getCurrencyResponses() {
        return currencyResponses;
    }

    public void setCurrencyResponses(List<CurrencyResponse> currencyResponses) {
        this.currencyResponses = currencyResponses;
    }

    public User(Long id, String ime, String prezime, String email, UserProfile userProfile, List<Membership> memberships, List<TimeApi> timeApiResponses) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.userProfile = userProfile;
        this.memberships = memberships;
        this.timeApiResponses = timeApiResponses;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(ime, user.ime) && Objects.equals(prezime, user.prezime) && Objects.equals(email, user.email) && Objects.equals(userProfile, user.userProfile) && Objects.equals(memberships, user.memberships) && Objects.equals(timeApiResponses, user.timeApiResponses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, prezime, email, userProfile, memberships, timeApiResponses);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", userProfile=" + userProfile +
                ", memberships=" + memberships +
                ", timeApiResponses=" + timeApiResponses +
                '}';
    }
}