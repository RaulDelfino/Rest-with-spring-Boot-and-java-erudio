package br.com.erudio.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.Exceptions.ResourceNotFoundException;
import br.com.erudio.controller.BooksController;

import br.com.erudio.data.vo.v1.BooksVO;
import br.com.erudio.mapper.Mapper;
import br.com.erudio.mapper.custom.BooksMapper;
import br.com.erudio.model.Books;
import br.com.erudio.repository.BooksRepository;

@Service
public class BooksServices {
    
    @Autowired
    BooksRepository booksRepository;

    @Autowired
    BooksMapper mapper;

    public BooksVO create(BooksVO booksVO) {
        
        var entity = Mapper.parseObject(booksVO, Books.class);
        entity.setId(null);

        var vo = Mapper.parseObject(booksRepository.save(entity), BooksVO.class);

        vo.add(linkTo(methodOn(BooksController.class).findById(vo.getId())).withSelfRel());

        return vo;
    }

    @SuppressWarnings("null")
    public BooksVO update(BooksVO newBooks) {
        
        Books entity = booksRepository.findById(newBooks.getId())
            .orElseThrow(()-> new ResourceNotFoundException("No record found for this ID"));

        entity.setAuthor(newBooks.getAuthor());
        entity.setLaunch_date(newBooks.getLaunch_date());
        entity.setPrice(newBooks.getPrice());
        entity.setTitle(newBooks.getTitle());


        var vo = Mapper.parseObject(booksRepository.save(entity), BooksVO.class);

        vo.add(linkTo(methodOn(BooksController.class).findById(vo.getId())).withSelfRel());
        
        return vo;
    }

    @SuppressWarnings("null")
    public BooksVO findById(Long id) {

        Books entity = booksRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("No record found for this ID"));

        var vo = Mapper.parseObject(entity, BooksVO.class);

         vo.add(linkTo(methodOn(BooksController.class).findById(vo.getId())).withSelfRel());

        return vo;
    }

    public List<BooksVO> findAll(){

        var books = Mapper.parseListObjects(booksRepository.findAll(), BooksVO.class);

        books.stream().forEach(b -> {
            try {
                b.add(linkTo(methodOn(BooksController.class).findById(b.getId())).withSelfRel());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } );

        return books;
    }

    @SuppressWarnings("null")
    public void delete(Long id){
        var entity = booksRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("No record found for this ID"));

        booksRepository.delete(entity);
    }
    

    
}
