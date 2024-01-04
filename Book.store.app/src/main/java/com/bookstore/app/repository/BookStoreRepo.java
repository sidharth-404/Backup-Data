package com.bookstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.app.model.Book;

@Repository
public interface BookStoreRepo extends JpaRepository<Book,Integer>{

}
