package com.bookstore.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.app.model.Book;
import com.bookstore.app.repository.BookStoreRepo;

@Service
public class BookStoreServiceImpl implements BookStoreService {
	@Autowired
	private BookStoreRepo repo;

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return repo.save(book);
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Book updateBookById(int id,Book book) {
		// TODO Auto-generated method stub
		return repo.save(book);
		
	
	}

	@Override
	public void deleteBookById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

}
