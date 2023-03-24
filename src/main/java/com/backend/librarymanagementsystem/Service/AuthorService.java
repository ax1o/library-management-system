package com.backend.librarymanagementsystem.Service;

import com.backend.librarymanagementsystem.DTO.AuthorRequestDto;
import com.backend.librarymanagementsystem.DTO.AuthorResponseDto;
import com.backend.librarymanagementsystem.Entity.Author;
import com.backend.librarymanagementsystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto){

        Author author = new Author();

        author.setName(authorRequestDto.getName());
        author.setEmail(authorRequestDto.getEmail());
        author.setMobNo(authorRequestDto.getMobNo());

        authorRepository.save(author);

        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setEmail(author.getEmail());
        authorResponseDto.setName(author.getName());

        return authorResponseDto;

    }

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

}
