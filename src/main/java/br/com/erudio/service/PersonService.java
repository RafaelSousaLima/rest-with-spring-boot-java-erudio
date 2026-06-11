package br.com.erudio.service;

import br.com.erudio.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonService.class);

    public List<Person> findByAll() {
        logger.info("Findall Persons");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            persons.add(cretePerson(i));
        }
        return persons;
    }

    public Person findById(Long id) {
        logger.info("Find one Person");
        return cretePerson(1);
    }


    private Person cretePerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("First Name" + i);
        person.setLastName("Last Name");
        person.setAddress("Rio de Janeiro - RJ");
        person.setGender("Male");
        return person;
    }
}
