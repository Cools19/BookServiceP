package com.book.service;


import org.springframework.data.jpa.repository.JpaRepository;

import com.book.model.Book;

public interface IAuthorRepository extends JpaRepository <Book,Integer>{

}
