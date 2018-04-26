package com.qp.pms.service;

import java.util.List;
import java.util.Optional;

import com.qp.pms.model.Book;
import com.qp.pms.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookService {
    @Autowired
    private BookRepository bookRespository;

    public List<Book> getAllBooks() {
        return bookRespository.findAll();
    }

	public Optional<Book> getBook(Long id) {
		return bookRespository.findById(id);
	}
}