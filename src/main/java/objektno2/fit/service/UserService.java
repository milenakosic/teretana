package objektno2.fit.service;

import objektno2.fit.model.User;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@Dependent
public class UserService {

    @Inject
    EntityManager em;

    @Transactional
    public User createUser(User user) {
        if (user == null) {
            throw new RuntimeException("User nije proslijeđen");
        }

        if (user.getIme() == null || user.getIme().isEmpty()) {
            throw new RuntimeException("Ime je prazno");
        }

        if (user.getPrezime() == null || user.getPrezime().isEmpty()) {
            throw new RuntimeException("Prezime je prazno");
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new RuntimeException("Email je prazan");
        }

        return em.merge(user);
    }

    @Transactional
    public List<User> getAllUsers() {
        List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();

        if (users.isEmpty()) {
            throw new RuntimeException("Nema korisnika.");
        }

        return users;
    }
}