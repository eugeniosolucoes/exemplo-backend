package br.com.vitorhugo.controller;

import br.com.vitorhugo.entity.Person;
import br.com.vitorhugo.exception.ResourceNotFoundException;
import br.com.vitorhugo.repository.PersonRepository;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexandre
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Person> all() {
        return (List<Person>) repository.findAll();
    }

    @PostMapping
    public Person save(@RequestBody Person person) {
        return repository.save(person);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found: " + id));
    }

    @PutMapping("/{id}")
    public Person update(@RequestBody Person person, @PathVariable Long id) {
        return repository.findById(id)
                .map(p -> {
                    p.setFirstName(person.getFirstName());
                    p.setLastName(person.getLastName());
                    return repository.save(p);
                })
                .orElseGet(() -> {
                    return repository.save(person);
                });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
