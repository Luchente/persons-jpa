package ru.netology.personsjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.personsjpa.domain.Person;
import ru.netology.personsjpa.domain.PersonId;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, PersonId> {

    // by city (регистронезависимо)
    List<Person> findByCityOfLivingIgnoreCase(String city);

    // age < X, сортировка по возрастанию: обращаемся к вложенному полю EmbeddedId через "idAge"
    List<Person> findByIdAgeLessThanOrderByIdAgeAsc(Integer age);

    // by name & surname, Optional (если дублей много — берём "первый" по возрасту)
    Optional<Person> findFirstByIdNameIgnoreCaseAndIdSurnameIgnoreCaseOrderByIdAgeAsc(String name, String surname);
}
