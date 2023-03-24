package com.backend.librarymanagementsystem.Service;


import com.backend.librarymanagementsystem.DTO.IssueBookRequestDto;
import com.backend.librarymanagementsystem.DTO.IssueBookResponseDto;
import com.backend.librarymanagementsystem.Entity.Book;
import com.backend.librarymanagementsystem.Entity.LibraryCard;
import com.backend.librarymanagementsystem.Entity.Record;
import com.backend.librarymanagementsystem.Enum.CardStatus;
import com.backend.librarymanagementsystem.Enum.TransactionStatus;
import com.backend.librarymanagementsystem.Repository.BookRepository;
import com.backend.librarymanagementsystem.Repository.LibraryCardRepository;
import com.backend.librarymanagementsystem.Repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RecordService {

    @Autowired
    RecordRepository recordRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LibraryCardRepository libraryCardRepository;

    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();

        //set Record
        Record record = new Record();
        record.setRecordNumber(String.valueOf(UUID.randomUUID()));
        record.setIssuedOperation(true);



        Book book;
        try{
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch (Exception e){
           throw new Exception("Invalid book Id");
        }

        LibraryCard libraryCard;
        try{
             libraryCard = libraryCardRepository.findById(issueBookRequestDto.getCardId()).get();
        }catch (Exception e){
            throw new Exception("Invalid card id");
        }


        //if book was not issued
        if(book.isIssued() == false && libraryCard.getStatus() == CardStatus.ACTIVATED){

            //fetch card details

            record.setBook(book);
            record.setCard(libraryCard);
            record.setRecordStatus(TransactionStatus.SUCCESS);


            //setting books
            List<Record> records = book.getRecords();
            records.add(record);
            book.setRecords(records);
            book.setCard(libraryCard);
            book.setIssued(true);

            //setting list of cards
            List<Book> books = libraryCard.getBooks();
            books.add(book);
            libraryCard.setBooks(books);
            List<Record>ListOfRecords = libraryCard.getRecords();
            ListOfRecords.add(record);
            libraryCard.setRecords(ListOfRecords);

            libraryCardRepository.save(libraryCard);

            //setting response

            issueBookResponseDto.setBookId(book.getId());
            issueBookResponseDto.setRecordNumber(record.getRecordNumber());
            issueBookResponseDto.setCardId(libraryCard.getCardNo());
            issueBookResponseDto.setRecordDate(record.getRecordDate());

        }else{
            throw new RuntimeException("Book was already issued or the card is Expired");
        }

        return issueBookResponseDto;

    }



}
