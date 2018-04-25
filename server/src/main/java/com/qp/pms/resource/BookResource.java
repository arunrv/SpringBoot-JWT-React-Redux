package com.qp.pms.resource;

import java.util.Arrays;
import java.util.List;

import com.qp.pms.model.Book;
import com.qp.pms.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookResource {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookService BookService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        List<Book> allBooks = null;
        //allBooks = Arrays.asList(new Book(1, "Java", "John Doe"), new Book(2, "React", "Jane"));
        allBooks = BookService.getAllBooks();
        logger.info("All Books -> {}", allBooks);
        return allBooks;
    }

}