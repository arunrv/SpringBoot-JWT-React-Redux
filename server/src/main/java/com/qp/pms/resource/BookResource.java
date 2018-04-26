package com.qp.pms.resource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.qp.pms.model.Book;
import com.qp.pms.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/book")
@Api(value = "Book Resource REST Endpoint", description = "Shows the book info")
public class BookResource {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookService bookService;

    @GetMapping
    @ApiOperation(value = "Returns list of Books")
    @ApiResponses(
            value = {
                @ApiResponse(code = 100, message = "100 is the message"),
                @ApiResponse(code = 200, message = "Successful Book List")
            }
    )
    public List<Book> getBooks() {
        List<Book> allBooks = null;
        //allBooks = Arrays.asList(new Book(1, "Java", "John Doe"), new Book(2, "React", "Jane"));
        allBooks = bookService.getAllBooks();
        logger.info("All Books -> {}", allBooks);
        return allBooks;
    }

    @GetMapping("/{id}") 
    @ApiOperation(value = "Returns a Book for the given id")
    public Optional<Book> getBook(@PathVariable("id") final Long id) {
        return bookService.getBook(id);
    }

}