package br.com.vitorhugo.repository;

import br.com.vitorhugo.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alexandre
 */
@Repository 
public interface PersonRepository extends CrudRepository<Person, Long> {
}
