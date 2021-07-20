package com.aamer.springboot.dao;

import com.aamer.springboot.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> db = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        db.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return db;
    }

    @Override
    public int deletePersonById(UUID id) {
       Optional<Person> personMaybe = selectPersonById(id);
       if(personMaybe.equals(null)) {
           return 0;
       }
       db.remove(personMaybe.get());
       return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id)
                .map(person -> {
                    int indexofPersonToDelete = db.indexOf(person);
                    if(indexofPersonToDelete >=0) {
                        db.set(indexofPersonToDelete,new Person(id,update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return db.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

}
