package com.example.bookstore.service;

import java.util.Date;
import java.util.List;

import com.example.bookstore.dao.BookDao;
import com.example.bookstore.model.Book;

public class BookServiceImpl implements BookService {
	
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return this.bookDao.findAll();
	}

	@Override
	public List<Book> findByName(String book_name) {
		// TODO Auto-generated method stub
		return this.bookDao.findByName(book_name);
	}

	@Override
	public List<Book> findByDate(Date date) {
		// TODO Auto-generated method stub
		return this.bookDao.findByDate(date);
	}

	@Override
	public List<Book> findByAuthor(String author) {
		// TODO Auto-generated method stub
		return this.bookDao.findByAuthor(author);
	}

	@Override
	public List<Book> findByPrice(Float price) {
		// TODO Auto-generated method stub
		return this.bookDao.findByPrice(price);
	}

	@Override
	public List<Book> findByNumber(Integer number) {
		// TODO Auto-generated method stub
		return this.bookDao.findByNumber(number);
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		this.bookDao.addBook(book);

	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		this.bookDao.updateBook(book);
	}

	@Override
	public void removeBook(int id) {
		// TODO Auto-generated method stub
		this.bookDao.removeBook(id);
	}

	@Override
	public Book findById(Integer book_id) {
		// TODO Auto-generated method stub
		return this.bookDao.findById(book_id);
	}

}
