package objektno2.fit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "memberships")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "membership_seq")
    @SequenceGenerator(name = "membership_seq", sequenceName = "membership_seq", allocationSize = 1)
    private Long id;

    private LocalDate datumPocetka;
    private LocalDate datumIsteka;
    private String status;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membership_plan_id")
    private MembershipPlan membershipPlan;

    public Membership() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDatumPocetka() { return datumPocetka; }
    public void setDatumPocetka(LocalDate datumPocetka) { this.datumPocetka = datumPocetka; }

    public LocalDate getDatumIsteka() { return datumIsteka; }
    public void setDatumIsteka(LocalDate datumIsteka) { this.datumIsteka = datumIsteka; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public MembershipPlan getMembershipPlan() { return membershipPlan; }
    public void setMembershipPlan(MembershipPlan membershipPlan) { this.membershipPlan = membershipPlan; }
}