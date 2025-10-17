package ru.netology.personsjpa.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.personsjpa.domain.Person;

import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<Person> getPersonsByCity(String city) {
        return em.createQuery(
                "SELECT p FROM Person p WHERE UPPER(p.cityOfLiving) = UPPER(:city)",
                Person.class
        ).setParameter("city", city).getResultList();
    }
}
