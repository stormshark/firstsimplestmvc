package com.stormshark.mvc.service;

import com.stormshark.mvc.dao.PersonDao;
import com.stormshark.mvc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgre")  PersonDao personDao) {
        this.personDao = personDao;
    }


    public int addPerson(Person person) {

        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public void deletePersonById(UUID id) {

        personDao.deletePersonById(id);
    }

    public Optional<Person> getPersonById(UUID id ) {

        return personDao.selectPersonByID(id);
    }

    public int updatePersonById(UUID id, Person newperson) {
        return personDao.updatePersonById(id,newperson);
    }

}
