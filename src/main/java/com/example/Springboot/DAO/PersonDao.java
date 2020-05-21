package com.example.Springboot.DAO;

import com.example.Springboot.Model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    // method to insert a person into the data base
    int insertPerson(UUID id, Person person);

    // method to insert a person into the data base with out specifying the id and generating it automatically.
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
    // creating a function to get all the people in the database
    List<Person> selectAllPeople();

    // method to select a person my their id.
    Optional<Person> selectPersonById(UUID id);

    // creating a method that allows us to delete from the database.
    int deletePersonById(UUID id);

    // method to update from the database.
    int updatePersonById(UUID id, Person person);
}
