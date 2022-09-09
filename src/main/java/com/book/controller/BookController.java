package com.book.controller;

import java.util.List;

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

import com.book.model.Book;
import com.book.service.IAuthorService;

@RestController
public class BookController {
	
@RequestMapping("/sample")

public String hello() {
	return " Learn springbook";
}

@Autowired
IAuthorService authorService;



@PostMapping("/Book")
Integer createBook (@RequestBody Book book){
	Integer id= authorService.saveBook(book);
	System.out.println(id);
	return id;
	
}

@GetMapping("/allBooks")
public List<Book>getBook(){
	return authorService.getAllBooks();
}

@DeleteMapping("/deleteBooks/{Id}")
public String deleteBook(@PathVariable Integer Id){
	authorService.deleteBook(Id);
	return "Deleted book " + Id ;
}

@PutMapping ("/updateBook/{id}")
public Integer updatebook(@RequestBody Book book, @PathVariable("id") Integer id){
	return authorService.updateBook(book,id);
}


@DeleteMapping ("/deleteBooks")
public String deleteAllBook() {
	authorService.deleteAll();
	return "Deleted all Book";
}







}
