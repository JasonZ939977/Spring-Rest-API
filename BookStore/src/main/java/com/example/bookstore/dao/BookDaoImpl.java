package com.example.bookstore.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.bookstore.model.Book;

public class BookDaoImpl implements BookDao{
	
	private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAll() {
		Session session = this.sessionFactory.getCurrentSession
				();
		List<Book> bookList = session.createQuery("from Book").list();
		for(Book b : bookList){
			logger.info("Book List::"+b);
		}
		return bookList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Book findById(Integer book_id) {
		Session session = this.sessionFactory.getCurrentSession();
		logger.info("Book id in DAO:" + book_id);
		Book book = (Book) session.get(Book.class, book_id);
		logger.info("Book ::"+book);
		return book;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findByName(String book_name) {
		Session session = this.sessionFactory.getCurrentSession();
		logger.info("Book name in DAO:" + book_name);
		List<Book> booksList = (List<Book>) session.get(Book.class, book_name);
		for(Book b : booksList){
			logger.info("Book List::"+b);
		}
		return booksList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findByDate(Date date) {
		Session session = this.sessionFactory.getCurrentSession();
		logger.info("Book name in DAO:" + date);
		List<Book> booksList = (List<Book>) session.get(Book.class, date);
		for(Book b : booksList){
			logger.info("Book List::"+b);
		}
		return booksList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findByAuthor(String author) {
		Session session = this.sessionFactory.getCurrentSession();
		logger.info("Book name in DAO:" + author);
		List<Book> booksList = (List<Book>) session.get(Book.class, author);
		for(Book b : booksList){
			logger.info("Book List::"+b);
		}
		return booksList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findByPrice(Float price) {
		Session session = this.sessionFactory.getCurrentSession();
		logger.info("Book name in DAO:" + price);
		List<Book> booksList = (List<Book>) session.get(Book.class, price);
		for(Book b : booksList){
			logger.info("Book List::"+b);
		}
		return booksList;
	}

	@Override
	public List<Book> findByNumber(Integer number) {
		Session session = this.sessionFactory.getCurrentSession();
		logger.info("Book name in DAO:" + number);
		@SuppressWarnings("unchecked")
		List<Book> booksList = (List<Book>) session.get(Book.class, number);
		for(Book b : booksList){
			logger.info("Book List::"+b);
		}
		return booksList;
	}

	@Override
	public void addBook(Book book) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(book);
		logger.info("Book saved successfully, Book Details="+book);
		
	}

	@Override
	public void updateBook(Book book) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(book);
		logger.info("Book updated successfully, Book Details="+book);
		
	}

	@Override
	public void removeBook(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Book b = (Book) session.load(Book.class, new Integer(id));
		if(null != b){
			session.delete(b);
		}
		logger.info("Book deleted successfully, Book details="+b);
	}

}
