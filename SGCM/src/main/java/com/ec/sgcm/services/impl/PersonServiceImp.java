package com.ec.sgcm.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import com.ec.sgcm.model.Persons;
import com.ec.sgcm.model.dto.PersonCompleteDTO;
import com.ec.sgcm.model.dto.PersonListDTO;
import com.ec.sgcm.repository.PersonRepo;
import com.ec.sgcm.services.PersonService;
import com.ec.sgcm.services.mappers.PersonMapper;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class PersonServiceImp implements PersonService {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonRepo personRepo;

    @Override
    public Persons createNewPerson(Persons person) {
        if (personRepo.findfindByIdentification(person.getIdentification()) != null) {
            throw new IllegalArgumentException("Person with this identification already exists");
        }
        return personRepo.save(person);
    }

    @Override
    public Persons updateNewPerson(Persons person) {
        Persons personExist = personRepo.findfindByIdentification(person.getIdentification());
        if (personExist == null) {
            throw new EntityNotFoundException("Person not found with identification: " + person.getIdentification());
        }
        personExist.setFirstName(person.getFirstName());
        personExist.setLastName(person.getLastName());
        personExist.setBirthDate(person.getBirthDate());
        personExist.setOccupancy(person.getOccupancy());
        return personRepo.save(personExist);
    }

    @Override
    public List<PersonListDTO> searchAllPerson() {
        List<Persons> personsList = personRepo.findAll();
        return personsList.stream()
                .map(PersonMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Persons searchPersonByIdentification(String identification) {
        Persons person = personRepo.findfindByIdentification(identification);
        if (person == null) {
            throw new EntityNotFoundException("Person not found with identification: " + identification);
        }
        return person;
    }

    @Override
    public List<PersonCompleteDTO> buscarPorNombre(String nombre) {
        List<Persons> personas = personRepo.findByFirstNameContainingIgnoreCase(nombre);
        return personas.stream().map(person -> new PersonCompleteDTO(
                person.getId(),
                person.getIdentification(),
                person.getFirstName(),
                person.getLastName(),
                person.getBirthDate(),
                person.getOccupancy())).collect(Collectors.toList());
    }
}
