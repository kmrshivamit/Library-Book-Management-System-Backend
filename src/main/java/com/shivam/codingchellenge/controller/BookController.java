package com.shivam.codingchellenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.codingchellenge.model.Book;
import com.shivam.codingchellenge.model.Categorie;
import com.shivam.codingchellenge.repo.BookRepo;
import com.shivam.codingchellenge.repo.CategorieRepo;

import Exception.CustomeException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookController {

	@Autowired
	BookRepo bookRepo;
	@Autowired
	CategorieRepo categorieRepo;

	@GetMapping("/book")
	public List<Book> getBooks() {
		 List<Book> li=bookRepo.findAll();
		 System.out.println(li);
		 return li;
	}
	
	@GetMapping("/book/{id}")
	public Book getBook ( @PathVariable long id)
	
	{Book b;
	try {
		b=bookRepo.findById(id).get();
	}
	catch(IllegalArgumentException e)
	{
		throw new CustomeException("Not able to find by id",e);
	}

	
	return b;
		
	}

	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		System.out.println(book);
		if(book==null)
			throw new CustomeException("Book does not have any value");
		return bookRepo.save(book);

	}

	@DeleteMapping("/book/{id}")
	public void DelteBook(@PathVariable long id) {
		System.out.println("In delete mapping");
		Book b = bookRepo.getOne(id);
		bookRepo.delete(b);
	}

}
