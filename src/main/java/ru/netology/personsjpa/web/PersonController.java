package ru.netology.personsjpa.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.personsjpa.domain.Person;
import ru.netology.personsjpa.domain.PersonId;
import ru.netology.personsjpa.repo.PersonJpaRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonJpaRepository repo;

    @GetMapping("/by-city")
    public List<Person> byCity(@RequestParam String city) {
        return repo.findByCityOfLivingIgnoreCase(city);
    }

    @GetMapping("/by-age-less")
    public List<Person> byAgeLess(@RequestParam Integer age) {
        return repo.findByIdAgeLessThanOrderByIdAgeAsc(age);
    }

    @GetMapping("/by-name-surname")
    public ResponseEntity<Person> byNameSurname(@RequestParam String name,
                                                @RequestParam String surname) {
        return repo.findFirstByIdNameIgnoreCaseAndIdSurnameIgnoreCaseOrderByIdAgeAsc(name, surname)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ----- базовые CRUD -----
    @GetMapping
    public List<Person> all() {
        return repo.findAll();
    }

    @GetMapping("/{name}/{surname}/{age}")
    public ResponseEntity<Person> byId(@PathVariable String name,
                                       @PathVariable String surname,
                                       @PathVariable Integer age) {
        return repo.findById(new PersonId(name, surname, age))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Person create(@RequestBody Person p) {
        // save для нового
        return repo.save(p);
    }

    @PutMapping
    public ResponseEntity<Person> update(@RequestBody Person p) {
        // save для апдейта; можно проверять existsById, если хочешь 404 на несуществующий
        return ResponseEntity.ok(repo.save(p));
    }

    @DeleteMapping("/{name}/{surname}/{age}")
    public ResponseEntity<Void> delete(@PathVariable String name,
                                       @PathVariable String surname,
                                       @PathVariable Integer age) {
        var id = new PersonId(name, surname, age);
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
