package com.shivam.codingchellenge.controller;

import java.util.List;
import java.util.NoSuchElementException;

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
public class CategorieController {

	@Autowired
	BookRepo bookRepo;
	@Autowired
	CategorieRepo categorieRepo;

	@GetMapping("/categorie")
	public List<Categorie> getCategorie() {

		List<Categorie> li = categorieRepo.findAll();
		if (li.size() == 0)
			throw new CustomeException("no categorie found");
		return li;

	}

	@GetMapping("/categorie/{id}")
	public Categorie getBook(@PathVariable long id) {
		Categorie c;
		try {
		c = categorieRepo.findById(id).get();
		System.out.println(c.getBooks());
		}
		catch(NoSuchElementException e) {
			throw new CustomeException("categorie not able to fetch",e);
	}
		catch(IllegalArgumentException  e1)
		{
			throw new CustomeException("categorie not able to fetch",e1);
		}
		
		return c;

	}

	@PostMapping("/categorie")
	public Categorie addCategorie(@RequestBody Categorie categorie) {
		Categorie c;

		try {
		c = categorieRepo.save(categorie);}
		catch(IllegalArgumentException e)
		{
			throw new CustomeException("not able to save");
		}
		return c;

	}

	@DeleteMapping("/categorie{id}")
	public void DelteCategorie(@PathVariable long id) {
		Categorie c = categorieRepo.getOne(id);
		try {
			categorieRepo.delete(c);
		} catch (IllegalArgumentException e) {
			throw new CustomeException("Not able to delete", e);
		}
	}

}
