package objektno2.fit.service;

import objektno2.fit.exeption.ResourceNotFound;
import objektno2.fit.model.CurrencyResponse;
import objektno2.fit.model.TimeApi;
import objektno2.fit.model.User;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import objektno2.fit.rest.client.CurrencyClient;
import objektno2.fit.rest.client.IpClient;
import objektno2.fit.rest.client.TimeApiClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Dependent
public class UserService {

    @Inject
    EntityManager em;

    @Inject
    @RestClient
    IpClient ipClient;

    @Inject
    @RestClient
    TimeApiClient timeApiClient;

    @Inject
    @RestClient
    CurrencyClient currencyClient;



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
        List<User> users = em.createQuery("FROM User", User.class).getResultList();

        if (users.isEmpty()) {
            throw new RuntimeException("Nema korisnika.");
        }

        return users;
    }

    public User getById(Long id){
        User user = em.find(User.class, id);
        if(user == null){
            throw new ResourceNotFound("Korisnik sa id= " + id + " nije pronadjen!");
        }
        return user;
    }

    public User findByEmail(String email) {
        List<User> users = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();

        if (users.isEmpty()) {
            throw new RuntimeException("Ne postoji korisnik sa emailom: " + email);
        }

        return users.get(0);
    }

    @Transactional
    public User assignTimeZoneByIp(Long userId) throws ResourceNotFound{
        User user = getById(userId);
        String ipResponse = ipClient.getIp();
        if(ipResponse == null){
            throw new ResourceNotFound("Nije moguce pronaci ip adresu");
        }
        TimeApi timeApi = timeApiClient.getTimeZoneByIp(ipResponse);
        if(timeApi == null){
            throw new ResourceNotFound("Nije moguce dobiti timezone za ip: " + ipResponse);
        }
        user.getTimeApiResponses().add(timeApi);
        return em.merge(user);
    }

    @Transactional
    public User assignCurrencyValue(String from, String to, double value, Long userId) throws ResourceNotFound{
        User user = getById(userId);
        CurrencyResponse currencyResponse = currencyClient.getCurenncy(from, to);
        if(currencyResponse == null){
            throw new ResourceNotFound("Nije moguce dobiti currency");
        }

        double convertedValue = value*currencyResponse.getRate();
        currencyResponse.setValue(value);

        currencyResponse.setConvertedValue(convertedValue);
        user.getCurrencyResponses().add(currencyResponse);
        return em.merge(user);

    }






}