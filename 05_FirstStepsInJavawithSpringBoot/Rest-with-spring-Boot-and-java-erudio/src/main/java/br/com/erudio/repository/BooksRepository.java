package br.com.erudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erudio.model.Books;

public interface BooksRepository extends JpaRepository<Books, Long>{}
