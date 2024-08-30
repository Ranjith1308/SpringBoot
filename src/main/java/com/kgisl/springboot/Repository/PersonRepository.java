package com.kgisl.springboot.Repository;

import org.springframework.data.repository.ListCrudRepository;
import com.kgisl.springboot.entity.Person;

public interface PersonRepository extends ListCrudRepository<Person,Long> {
    
}
