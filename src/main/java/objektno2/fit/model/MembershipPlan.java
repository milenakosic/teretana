package objektno2.fit.model;

import jakarta.persistence.*;

@Entity
@Table(name = "membership_plans")
public class MembershipPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "membership_plan_seq")
    @SequenceGenerator(name = "membership_plan_seq", sequenceName = "membership_plan_seq", allocationSize = 1)
    private Long id;

    private String naziv;
    private double cijena;
    private int trajanjeDana;

    public MembershipPlan() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public int getTrajanjeDana() {
        return trajanjeDana;
    }

    public void setTrajanjeDana(int trajanjeDana) {
        this.trajanjeDana = trajanjeDana;
    }
}