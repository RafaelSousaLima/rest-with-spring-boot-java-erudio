package br.com.erudio.service;

import br.com.erudio.dto.person.v1.PersonDTO;
import br.com.erudio.dto.person.v2.PersonDTOV2;
import br.com.erudio.exception.ResouceNotFundException;
import br.com.erudio.model.Person;
import br.com.erudio.model.custom.PersonMapper;
import br.com.erudio.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.erudio.mapper.ObjectMapper.parseList;
import static br.com.erudio.mapper.ObjectMapper.parseObject;

@Service
public class PersonService {

    private Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    public List<PersonDTO> findByAll() {
        logger.debug("Finding all persons");
        return parseList(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding person by id {}", id);
        Person person = personRepository.findById(id).orElseThrow(() -> new ResouceNotFundException("No records found for this id"));
        return parseObject(person, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating person {}", person);
        return parseObject(personRepository.save(parseObject(person, Person.class)), PersonDTO.class);
    }

    public PersonDTOV2 create(PersonDTOV2 person) {
        logger.info("Creating person V2 {}", person);
        return personMapper.convertEntityToDTO(personRepository.save(personMapper.convertEntityToDTO(person)));
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Updating person {}", person);
        Person updatedPerson = personRepository.findById(person.getId()).get();
        updatedPerson.setFristName(person.getFristName());
        updatedPerson.setLastName(person.getLastName());
        updatedPerson.setAddress(person.getAddress());
        updatedPerson.setGender(person.getGender());
        return parseObject(personRepository.save(updatedPerson), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting person {}", id);
        personRepository.delete(personRepository.findById(id).get());
    }

}
