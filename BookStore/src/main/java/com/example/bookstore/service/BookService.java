package com.example.bookstore.service;

import java.util.Date;
import java.util.List;

import com.example.bookstore.model.Book;

public interface BookService {
	public List<Book> findAll();
	public Book findById(Integer book_id);
	public List<Book> findByName(String book_name);
	public List<Book> findByDate(Date date);
	public List<Book> findByAuthor(String author);
	public List<Book> findByPrice(Float price);
	public List<Book> findByNumber(Integer number);
	public void addBook(Book book);
	public void updateBook(Book book);
	public void removeBook(int id);
}
