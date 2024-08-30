package com.kgisl.springboot.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.springboot.Repository.PersonRepository;
import com.kgisl.springboot.entity.Person;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/findAll")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id){
        personRepository.deleteById(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable Long id, @RequestBody Person person){
        personRepository.save(person);
        return new ResponseEntity<>("Updated Successfully",HttpStatus.ACCEPTED);
    }

    // @GetMapping("/getId/{id}")
    // public ResponseEntity<String> getPerson(@PathVariable Long id){
    //     personRepository.findById(id);
    //     return new ResponseEntity<>("Id got it",HttpStatus.FOUND);
    // }
    
    @GetMapping("/{id}")
    public Optional<Person> getPerson(@PathVariable Long id){
        return personRepository.findById(id);
    }
    
}
