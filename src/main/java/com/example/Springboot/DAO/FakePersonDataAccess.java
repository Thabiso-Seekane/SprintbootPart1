package com.example.Springboot.DAO;

import com.example.Springboot.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("FakeDao")
public class FakePersonDataAccess  implements PersonDao{

    // here we define our list of persons.
    private static List<Person> DB = new ArrayList();
    @Override
    public int insertPerson(UUID id, Person person) {
        // than we add to our database list.
        DB.add(new Person(id,person.getName(), person.getSurname()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream() // a way to search the database.
                .filter(person -> person.getId()
                .equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id)
                .map(person1 -> {
                    int indexOfPersonToUpdate = DB.indexOf(person1);
                    if (indexOfPersonToUpdate >= 0){
                        DB.set(indexOfPersonToUpdate, new Person(id, update.getName(), update.getSurname()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
