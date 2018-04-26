package com.qp.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import com.qp.pms.model.Book;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {

	Object findByName(String name);
}
