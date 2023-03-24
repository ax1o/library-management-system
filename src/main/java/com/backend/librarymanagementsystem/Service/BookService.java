package com.backend.librarymanagementsystem.Service;

import com.backend.librarymanagementsystem.DTO.BookRequestDto;
import com.backend.librarymanagementsystem.DTO.BookResponseDto;
import com.backend.librarymanagementsystem.Entity.Author;
import com.backend.librarymanagementsystem.Entity.Book;
import com.backend.librarymanagementsystem.Repository.AuthorRepository;
import com.backend.librarymanagementsystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public BookResponseDto addBook(BookRequestDto bookRequestDto) throws Exception {

        Author author;
        try{
            author = authorRepository.findById(bookRequestDto.getAuthorId()).get();
        }catch (Exception e){
            throw new RuntimeException("Author not found");
        }

        Book book = new Book();
        book.setAuthor(author);
        book.setPrice(bookRequestDto.getPrice());
        book.setIssued(false);
        book.setGenre(bookRequestDto.getGenre());
        book.setTitle(bookRequestDto.getTitle());

        List<Book> books = author.getBooks();
        books.add(book);
        author.setBooks(books);

        authorRepository.save(author);

        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setPrice(book.getPrice());
        bookResponseDto.setTitle(book.getTitle());

        return bookResponseDto;
    }

}
