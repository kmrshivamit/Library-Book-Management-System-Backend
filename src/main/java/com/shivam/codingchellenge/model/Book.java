package com.shivam.codingchellenge.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.criteria.Fetch;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	@Id
	@GeneratedValue
	private long bookId;
	private String bookName;
	private String author;
	
	@ManyToOne(  cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	  @JoinColumn(name="categorie_id")
	private Categorie categorie;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(long bookId, String bookName, String author, Categorie categorie) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.categorie = categorie;
	}
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	

	

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", categorie=" + categorie
				+ "]";
	}

	public void addCategorie(Categorie categorie2) {
		categorie=categorie2;
		
	}

}
