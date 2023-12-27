package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.Exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        logger.info("Finding All person");
        return repository.findAll();
    }

    public Person create(Person person) {
        logger.info("Creating one Person");
        return repository.save(person);
    }

    
    public Person update(Person newPerson) {
        logger.info("Updating one Person");

        Person person = repository.findById(newPerson.getId())
            .orElseThrow(()-> new ResourceNotFoundException("No record found for this ID"));

        person.setFirstName(newPerson.getFirstName());
        person.setLastName(newPerson.getLastName());
        person.setAddress(newPerson.getAddress());
        person.setGender(newPerson.getGender());


        return repository.save(person);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person");

        var entity = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));

        repository.delete(entity);
    }


    public Person findById(Long id){
        logger.info("Finding one person"); //Infromações no logger da aplicação


        return repository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("No record found for this ID"));
    }

}
