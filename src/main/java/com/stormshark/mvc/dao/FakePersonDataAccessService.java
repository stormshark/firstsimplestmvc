package com.stormshark.mvc.dao;

import com.stormshark.mvc.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonByID(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deletePersonById(UUID id) {
        Optional<Person> personMaybe= selectPersonByID(id);
        DB.remove(personMaybe.get());

    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonByID(id)
            .map (person -> {
            int indexOfPersonToUpdate = DB.indexOf(person);
            if (indexOfPersonToUpdate >=0) {
                DB.set(indexOfPersonToUpdate,new Person(id, update.getName()));
                return 1;
            }
            return 0;
        })
             .orElse(0);
    }
}
