package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.erudio.Exceptions.ResourceNotFoundException;
import br.com.erudio.controller.PersonController;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOv2;
import br.com.erudio.mapper.Mapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper mapper;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<PersonVO> findAll() {
        logger.info("Finding All person");

        var persons = Mapper.parseListObjects(repository.findAll(), PersonVO.class);

        persons.stream().forEach(p -> {
            try {
                p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } );
        return persons;
    }

    public PersonVO create(PersonVO personVO) throws Exception {
        logger.info("Creating one PersonVO");
        var entity = Mapper.parseObject(personVO, Person.class );
        var vo = Mapper.parseObject(repository.save(entity), PersonVO.class);
        
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    
    public PersonVOv2 createV2(PersonVOv2 personVO) throws Exception {
        
        logger.info("Creating one Person with V2!");
        var entity = mapper.convertVoToEntity(personVO);
        var vo = mapper.convertEntityToVo(repository.save(entity));
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    
    public PersonVO update(PersonVO newPersonVO) throws Exception {
        logger.info("Updating one Person");

        var entity = repository.findById(newPersonVO.getKey())
            .orElseThrow(()-> new ResourceNotFoundException("No record found for this ID"));

        entity.setFirstName(newPersonVO.getFirstName());
        entity.setLastName(newPersonVO.getLastName());
        entity.setAddress(newPersonVO.getAddress());
        entity.setGender(newPersonVO.getGender());

        var vo = Mapper.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(long id) {
        logger.info("Deleting one Person");

        var entity = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));

        repository.delete(entity);
    }


    public PersonVO findById(long id) throws Exception {
        logger.info("Finding one person"); //Infromações no logger da aplicação


        var entity = repository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("No record found for this ID"));
        
        var vo = Mapper.parseObject(entity, PersonVO.class);    
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }

}
