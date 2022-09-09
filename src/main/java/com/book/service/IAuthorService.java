package com.book.service;

import java.util.List;
import java.util.Optional;

import com.book.model.Book;

public interface IAuthorService {
	
public Integer saveBook(Book book);
public List <Book>getAllBooks();
public Optional <Book>getBook(Integer id);
public String deleteBook(Integer id);
public Integer updateBook(Book book, Integer Id);
public String deleteAll();
}