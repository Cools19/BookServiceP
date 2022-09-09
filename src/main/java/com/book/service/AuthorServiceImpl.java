package com.book.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.model.Book;


@Service
public class AuthorServiceImpl implements IAuthorService {

	
	@Autowired
	IAuthorRepository authorRepository;

	

	@Override 
	public Integer saveBook(Book book) {
		Book savedBook = authorRepository.save(book);
		return savedBook.getId();
	}
	
   @Override
     public  List <Book>getAllBooks(){
		return authorRepository.findAll();
	}
	@Override
	public Optional <Book>getBook(Integer id){
		return authorRepository.findById(id);	
	}

	@Override
	public String deleteBook(Integer Id) {
		authorRepository.deleteById(Id);
		return "Deleted Book" + Id ;
		
	}
	
	@Override
	public Integer updateBook (Book book, Integer Id) {
		Book existingBook = authorRepository.findById(Id)
				.orElseThrow(() ->  new com.book.exceptionhandling.ResourceNotFoundException 
				("Book", "Id",Id.toString()));
		
		existingBook.setTitle(book.getTitle());
		existingBook.setCategory(book.getCategory());
		existingBook.setImage(book.getImage());
		existingBook.setPrice(book.getPrice());
		existingBook.setPublisher(book.getPublisher());
		existingBook.setActive(book.getActive());
		existingBook.setContent(book.getContent());
		authorRepository.save(existingBook);
		return existingBook.getId();
		
	}
	
	@Override 
	public String deleteAll() {
		authorRepository.deleteAll();
		return "Deleted All";
	}
	
	}



