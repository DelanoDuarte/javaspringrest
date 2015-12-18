package br.com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.domain.Person;
import br.com.app.repository.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Person> getAll() {
		return repo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public Person createPerson(@RequestBody Person person) {
		return repo.save(person);
	}

	@ResponseStatus(code = HttpStatus.OK, reason = "Object Deleted")
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void deletePerson(@PathVariable Long id) {
		repo.delete(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
	public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
		Person p = repo.findOne(id);
		p.setName(person.getName());
		p.setSurname(person.getSurname());
		return repo.save(p);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/find/{id}")
	public Person showPerson(@PathVariable Long id) {
		return repo.findOne(id);
	}
}
