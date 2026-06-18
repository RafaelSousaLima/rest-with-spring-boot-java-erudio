package br.com.erudio.controllers;

import br.com.erudio.dto.person.v1.PersonDTO;
import br.com.erudio.dto.person.v2.PersonDTOV2;
import br.com.erudio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping(value = "person"
)
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}")
    public PersonDTO findById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @GetMapping(value = "/all")
    public List<PersonDTO> findByAll() {
        return personService.findByAll();
    }

    @PostMapping()
    public PersonDTO save(@RequestBody PersonDTO person) {
        return personService.create(person);
    }

    @PostMapping(value = "v2")
    public PersonDTOV2 savePersonV2(@RequestBody PersonDTOV2 person) {
        return personService.create(person);
    }

    @PutMapping()
    public PersonDTO update(@RequestBody PersonDTO person) {
        return personService.update(person);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
