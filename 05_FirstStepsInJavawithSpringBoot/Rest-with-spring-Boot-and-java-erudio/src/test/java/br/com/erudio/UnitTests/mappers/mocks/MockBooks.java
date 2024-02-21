package br.com.erudio.UnitTests.mappers.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.erudio.data.vo.v1.BooksVO;
import br.com.erudio.model.Books;

public class MockBooks {
    
    public Books mockEntity(){
        return mockEntity(0);
    }

    public Books mockEntity(Integer number){
        Books books = new Books();
        books.setAuthor("Author Test" + number);
        books.setId(number.longValue());
        books.setPrice(number);
        books.setLaunch_date(new Date(number));
        books.setTitle("Title Test" + number);
        
        return books;

    }

    public BooksVO mockVO(){
        return mockVO(0);
    }

    public BooksVO mockVO(Integer number){
        BooksVO books = new BooksVO();
        books.setAuthor("Author Test" + number);
        books.setId(number.longValue());
        books.setPrice(number);
        books.setLaunch_date(new Date());
        books.setTitle("Title Test" + number);
        
        return books;
    }

    public List<Books> mockEntityList(){
        List<Books> books = new ArrayList<Books>();
        for(int i = 0; i < 14; i++){
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BooksVO> mockVOList(){
        List<BooksVO> books = new ArrayList<BooksVO>();
        for(int i = 0; i < 14; i++){
            books.add(mockVO(i));
        }
        return books;
    }


}
