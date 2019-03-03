package com.example.bookstore.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;

@RestController
public class BookController {

	private BookService bookService;

	@Autowired(required=true)
	@Qualifier(value="studentService")
	public void setBookService(BookService bs){
		bookService = bs;
		
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> getBooksInJSON() {
		System.out.println("This is called now");  // testing not working
		return bookService.findAll();
	}
	
	@RequestMapping("/test")
	public String index() {
		return "Here is the book";
	}

	@RequestMapping(value = "/books/{bookName}", method = RequestMethod.GET)
	public @ResponseBody List<Book> getBookByName(@PathVariable() String book_name) {

		System.out.println(book_name);
		return bookService.findByName(book_name);
	}
	
	@RequestMapping(value = "/books/{date}", method = RequestMethod.GET)
	public @ResponseBody List<Book> getBookByDate(@PathVariable() Date date) {

		System.out.println(date);
		return bookService.findByDate(date);
	}
	
	@RequestMapping(value = "/books/{author}", method = RequestMethod.GET)
	public @ResponseBody List<Book> getBookByAuthor(@PathVariable() String author) {

		System.out.println(author);
		return bookService.findByAuthor(author);
	}
	
	@RequestMapping(value = "/books/{price}", method = RequestMethod.GET)
	public @ResponseBody List<Book> getBookByPrice(@PathVariable() Float price) {

		System.out.println(price);
		return bookService.findByPrice(price);
	}
	
	@RequestMapping(value = "/books/{number}", method = RequestMethod.GET)
	public @ResponseBody List<Book> getBookByNumber(@PathVariable() Integer number) {

		System.out.println(number);
		return bookService.findByNumber(number);
	}
	
	@RequestMapping(value= "/student", method = RequestMethod.POST)
	public @ResponseBody String save(@RequestBody Book jsonString) {

		if(jsonString.getId() == 0){
			//new student, add it
			bookService.addBook(jsonString);;
		}
		return "Book is Added.";
	}

	@RequestMapping(value= "/student/{book_id}", method = RequestMethod.PUT)
	public @ResponseBody String update(@PathVariable() Integer book_id, @RequestBody Book jsonString) {
		Book b = bookService.findById(book_id);
		if(jsonString.getPrice() == null)
			return "failed";
		b.setPrice(jsonString.getPrice());
		bookService.updateBook(b);
		return "updated";
	}


	@RequestMapping(value = "/student/{book_id}", method = RequestMethod.DELETE)
    public @ResponseBody String removeBook(@PathVariable("book_id") int book_id){		
        bookService.removeBook(book_id);
        return "removed";
    }

}
