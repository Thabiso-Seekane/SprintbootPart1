package com.example.Springboot.API;

import com.example.Springboot.Model.Person;
import com.example.Springboot.Service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("API/v1/person")
public class Controller {
    // created our services reference.
    private final Services services;

    @Autowired
    public Controller(Services services){
        this.services = services;
    }
    @PostMapping  // used to put,add, insert a person to the data base.
    // create a method that adds a person
    public void addPerson(@RequestBody Person person){
        services.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPeople(){
        return services.getAllPeople();
    }
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return services.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
         services.deletePersonById(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate){
        services.updatePerson(id,personToUpdate);
    }
}
