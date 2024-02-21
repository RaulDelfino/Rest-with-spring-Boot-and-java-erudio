package br.com.erudio.mapper.custom;


import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v1.BooksVO;
import br.com.erudio.model.Books;


@Service
public class BooksMapper {

        public BooksVO convertEntityToVo(Books book){
        BooksVO vo = new BooksVO();

        vo.setId(book.getId());
        vo.setAuthor(book.getAuthor());
        vo.setLaunch_date(book.getLaunch_date());
        vo.setPrice(book.getPrice());
        vo.setTitle(book.getTitle());
        
        
        return vo;
    }

      public Books convertVoToEntity (BooksVO booksVO){
        Books entity = new Books();

        entity.setId(booksVO.getId());
        entity.setAuthor(booksVO.getAuthor());
        entity.setLaunch_date(booksVO.getLaunch_date());
        entity.setPrice(booksVO.getPrice());
        entity.setTitle(booksVO.getTitle());

        return entity;
    }

}
