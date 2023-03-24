package com.backend.librarymanagementsystem.Repository;

import com.backend.librarymanagementsystem.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
