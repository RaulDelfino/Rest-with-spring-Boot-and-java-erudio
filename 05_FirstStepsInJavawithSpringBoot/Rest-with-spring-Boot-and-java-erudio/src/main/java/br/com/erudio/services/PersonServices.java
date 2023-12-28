package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.Exceptions.ResourceNotFoundException;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.mapper.Mapper;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<PersonVO> findAll(){
        logger.info("Finding All person");

        return Mapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO personVO) {
        logger.info("Creating one PersonVO");
        var entity = Mapper.parseObject(personVO, Person.class );
        var vo = Mapper.parseObject(repository.save(entity), PersonVO.class);
        
        return vo;
    }

    
    public PersonVO update(PersonVO newPersonVO) {
        logger.info("Updating one Person");

        var entity = repository.findById(newPersonVO.getId())
            .orElseThrow(()-> new ResourceNotFoundException("No record found for this ID"));

        entity.setFirstName(newPersonVO.getFirstName());
        entity.setLastName(newPersonVO.getLastName());
        entity.setAddress(newPersonVO.getAddress());
        entity.setGender(newPersonVO.getGender());

        var vo = Mapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id) {
        logger.info("Deleting one Person");

        var entity = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));

        repository.delete(entity);
    }


    public PersonVO findById(Long id){
        logger.info("Finding one person"); //Infromações no logger da aplicação


        var entity = repository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("No record found for this ID"));
        
        return Mapper.parseObject(entity, PersonVO.class);    
    }

}
