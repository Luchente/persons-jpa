package ru.netology.personsjpa.web;

import org.springframework.web.bind.annotation.*;
import ru.netology.personsjpa.domain.Person;
import ru.netology.personsjpa.repo.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository repo;

    public PersonController(PersonRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/by-city")
    public List<Person> byCity(@RequestParam String city) {
        return repo.getPersonsByCity(city);
    }
}
