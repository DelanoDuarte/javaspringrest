package br.com.app.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.app.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	
	

}
