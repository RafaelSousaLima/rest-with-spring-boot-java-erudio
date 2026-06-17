package br.com.erudio.model.custom;

import br.com.erudio.dto.person.v2.PersonDTOV2;
import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTOV2 convertEntityToDTO(Person person) {
        PersonDTOV2 dto = new PersonDTOV2();
        dto.setId(person.getId());
        dto.setFirstName(person.getFristName());
        dto.setLastName(person.getLastName());
        dto.setGender(person.getGender());
        dto.setAddress(person.getAddress());
        dto.setBirthDate(new Date());
        return dto;
    }

    public Person convertEntityToDTO(PersonDTOV2 dtov2) {
        Person person1 = new Person();
        person1.setId(dtov2.getId());
        person1.setFristName(dtov2.getFirstName());
        person1.setLastName(dtov2.getLastName());
        person1.setGender(dtov2.getGender());
        person1.setAddress(dtov2.getAddress());
        person1.setBirthDay(dtov2.getBirthDate());
        return person1;
    }

}
