package com.shivam.codingchellenge.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivam.codingchellenge.model.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
  
}
