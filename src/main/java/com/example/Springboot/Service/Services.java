package com.example.Springboot.Service;

import com.example.Springboot.DAO.PersonDao;
import com.example.Springboot.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Services {
    // this is our reference to our PersonDao interface
    private final PersonDao personDao;

    @Autowired  // this is injecting into the actual constructor
    public Services(@Qualifier("FakeDao") PersonDao personDao){
        this.personDao =personDao;
    }
    //we create a method to insert a new person.
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
    // creating a method to get all the people
    public List<Person> getAllPeople(){
        return this.personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePersonById(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson) {
        return personDao.updatePersonById(id, newPerson);
    }
}
