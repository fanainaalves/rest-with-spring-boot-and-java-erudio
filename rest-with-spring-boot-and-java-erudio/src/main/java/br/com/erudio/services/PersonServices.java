package br.com.erudio.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.*;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;


@Service
public class PersonServices {
	private final AtomicLong counter = new AtomicLong();
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public Person findById(String id) {
		logger.info("Finding a person");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Leandro");
		person.setLastName("Costa");
		person.setAddress("Uberlandia - MG");
		person.setGender("Male");
		return person;
	}
	
}
