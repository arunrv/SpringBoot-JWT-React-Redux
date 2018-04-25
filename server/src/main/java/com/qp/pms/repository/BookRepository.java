package com.qp.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qp.pms.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
