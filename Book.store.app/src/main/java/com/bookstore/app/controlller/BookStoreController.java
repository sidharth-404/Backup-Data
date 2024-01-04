package com.bookstore.app.controlller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.app.model.Book;
import com.bookstore.app.service.BookStoreServiceImpl;

@RestController
@RequestMapping("/api/book")
public class BookStoreController {
	@Autowired
	private BookStoreServiceImpl service;
	
	@PostMapping()
	public Book addBook(@RequestBody Book book)
	{
		return service.addBook(book);
	}
	@GetMapping()
	public List<Book> getAllBook()
	{
		return service.getAllBook();
		
	}
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id)
    {
    	return service.getBookById(id);
    }
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id,@RequestBody Book book)
    {
    	return service.updateBookById(id,book);
    }
    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable int id)
    {
    	service.deleteBookById(id);
    }
    
}
