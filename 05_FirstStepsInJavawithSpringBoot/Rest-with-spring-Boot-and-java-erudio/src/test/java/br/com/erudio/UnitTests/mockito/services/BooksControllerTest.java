package br.com.erudio.UnitTests.mockito.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.erudio.UnitTests.mappers.mocks.MockBooks;
import br.com.erudio.data.vo.v1.BooksVO;
import br.com.erudio.model.Books;
import br.com.erudio.repository.BooksRepository;
import br.com.erudio.services.BooksServices;

public class BooksControllerTest {

    
    MockBooks input;
    
    @InjectMocks
    private BooksServices services;

    @Mock
    BooksRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockBooks();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {

        Books persisted = input.mockEntity(1);
        persisted.setId(1L);

        BooksVO vo = input.mockVO(1);
        vo.setId(1L);

        when(repository.save(any(Books.class))).thenReturn(persisted);

        var result = services.create(vo);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("[</api/books/v1/1>;rel=\"self\"]"));
        assertEquals("Author Test1", result.getAuthor());
        assertEquals("Title Test1", result.getTitle());
        assertEquals(1, result.getPrice());

    }

    @Test
    void testDelete() {
        Books entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        
        services.delete(1L);
    
    }   

    @Test
    void testFindAll() {
        List<Books> list = input.mockEntityList();

        when(repository.findAll()).thenReturn(list);

        var books = services.findAll();

        assertNotNull(list);
        assertEquals(14, list.size());

        var book = books.get(1);
        assertNotNull(book);
        assertNotNull(book.getId());
        assertNotNull(book.getLinks());

        assertTrue(book.toString().contains("[</api/books/v1/1>;rel=\"self\"]"));
        assertEquals("Author Test1", book.getAuthor());
        assertEquals("Title Test1", book.getTitle());
        assertEquals(1, book.getPrice());

        var book4 = books.get(4);

        assertNotNull(book4);
        assertNotNull(book4.getId());
        assertNotNull(book4.getLinks());

        assertTrue(book4.toString().contains("[</api/books/v1/4>;rel=\"self\"]"));
        assertEquals("Author Test4", book4.getAuthor());
        assertEquals("Title Test4", book4.getTitle());
        assertEquals(4, book4.getPrice());

        var book7 = books.get(7);

        assertNotNull(book7);
        assertNotNull(book7.getId());
        assertNotNull(book7.getLinks());

        assertTrue(book7.toString().contains("[</api/books/v1/7>;rel=\"self\"]"));
        assertEquals("Author Test7", book7.getAuthor());
        assertEquals("Title Test7", book7.getTitle());
        assertEquals(7, book7.getPrice());

    }

    @Test
    void testFindById() {
        Books entity = input.mockEntity(1);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var book = services.findById(1L);

        assertNotNull(book);
        assertNotNull(book.getId());
        assertNotNull(book.getLinks());

        assertTrue(book.toString().contains("[</api/books/v1/1>;rel=\"self\"]"));
        assertEquals("Author Test1", book.getAuthor());
        assertEquals("Title Test1", book.getTitle());
        assertEquals(1, book.getPrice());

    }

    @Test
    void testUpdate() {
        Books entity = input.mockEntity(1);

        Books persisted = entity;
        persisted.setId(1L);

        BooksVO vo = input.mockVO(1);
        vo.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(persisted);

        var result = services.update(vo);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("[</api/books/v1/1>;rel=\"self\"]"));
        assertEquals("Author Test1", result.getAuthor());
        assertEquals("Title Test1", result.getTitle());
        assertEquals(1, result.getPrice());






    }
}
