package br.com.erudio.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOv2;
import br.com.erudio.services.PersonServices;
import br.com.erudio.util.MediaType;


@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping(value = "/{id}", 
        produces = {
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML
            })
	public PersonVO findById(@PathVariable(value ="id") Long id) throws Exception{
    
        return service.findById(id);
    
    }

    @GetMapping(
        produces = {
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML
            })
    public List<PersonVO> findAll() {
        return service.findAll();
    }

    @PostMapping(
        consumes =  {
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML, 
            MediaType.APPLICATION_YML
        }, 
        produces = {
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML
            })
    public PersonVO create(@RequestBody PersonVO person) throws Exception {
        return service.create(person);
    }
    @PostMapping(value = "/v2", 
        consumes = {
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML, 
            MediaType.APPLICATION_YML
        }, 
        produces = {
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML
            })
    public PersonVOv2 createV2(@RequestBody PersonVOv2 person) throws Exception {
        return service.createV2(person);
    }
    
    
    @PutMapping(
        consumes = {
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML, 
            MediaType.APPLICATION_YML
        }, 
        produces = {
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML
            })
    public PersonVO update(@RequestBody PersonVO person) throws Exception {
        return service.update(person);
    }


    @DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value ="id") Long id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
