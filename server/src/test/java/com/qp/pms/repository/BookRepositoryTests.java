package com.qp.pms.repository;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qp.pms.model.Book;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTests {

    @Autowired
    private BookRepository bookRepository;

    @Before
    public void setup() {
    }
    
    @Test
    public void getBooks() {
        List<Book> books = bookRepository.findAll();

        assertFalse(books.size() != 3);
    }
    
    @Test
    public void getBook() {
        Optional<Book> book = bookRepository.findById(new Long(1));

        assertNotNull(book);
        assertNotNull(book.get());
        assertEquals(book.get().getName(), "Mastering Spring Boot");
        assertEquals(book.get().getAuthor(), "John Doe");
    }
}