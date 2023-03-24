package com.backend.librarymanagementsystem.Service;


import com.backend.librarymanagementsystem.DTO.*;
import com.backend.librarymanagementsystem.Entity.Book;
import com.backend.librarymanagementsystem.Entity.LibraryCard;
import com.backend.librarymanagementsystem.Entity.Record;
import com.backend.librarymanagementsystem.Entity.Student;
import com.backend.librarymanagementsystem.Enum.CardStatus;
import com.backend.librarymanagementsystem.Enum.TransactionStatus;
import com.backend.librarymanagementsystem.Repository.BookRepository;
import com.backend.librarymanagementsystem.Repository.LibraryCardRepository;
import com.backend.librarymanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LibraryCardRepository libraryCardRepository;

    public UpdateStudentEmailResponseDto addStudent(CreateStudentRequestDto createStudentRequestDto){

//        //set card values
//        LibraryCard card = new LibraryCard();
//        card.setStatus(CardStatus.ACTIVATED);
//        card.setValidTill("05/2030");
//        card.setStudent(student);
//
//        //set student
//        student.setCard(card);
//
//        studentRepository.save(student);

          Student student = new Student();

          //setting student
          student.setName(createStudentRequestDto.getName());
          student.setEmail(createStudentRequestDto.getEmail());
          student.setDepartment(createStudentRequestDto.getDepartment());
          student.setAge(createStudentRequestDto.getAge());

          //setting card
          LibraryCard libraryCard = new LibraryCard();
          libraryCard.setStudent(student);
          libraryCard.setStatus(CardStatus.ACTIVATED);

          student.setCard(libraryCard);

          Student s = studentRepository.save(student);

          //create Response DTO
          UpdateStudentEmailResponseDto updateStudentEmailResponseDto = new UpdateStudentEmailResponseDto();
          updateStudentEmailResponseDto.setEmail(s.getEmail());
          updateStudentEmailResponseDto.setName(s.getName());
          updateStudentEmailResponseDto.setDepartment(s.getDepartment());

          return updateStudentEmailResponseDto;

    }

    public UpdateStudentEmailResponseDto getStudentByEmail(UpdateStudentEmailRequestDto updateStudentEmailRequestDto){

        Student student = studentRepository.findByEmail(updateStudentEmailRequestDto.getEmail());

        UpdateStudentEmailResponseDto updateStudentEmailResponseDto = new UpdateStudentEmailResponseDto();

        updateStudentEmailResponseDto.setName(student.getName());
        updateStudentEmailResponseDto.setDepartment(student.getDepartment());
        updateStudentEmailResponseDto.setEmail(student.getEmail());

        return updateStudentEmailResponseDto;

    }

    public UpdateStudentEmailResponseDto updateStudentEmail(UpdateStudentEmailRequestDto updateStudentEmailRequestDto){

        //find student with given id
        Student student;
        try{
            student = studentRepository.findById(updateStudentEmailRequestDto.getId()).get();
        }catch(Exception e){
            throw new RuntimeException("Student with given ID Not found");
        }

        //change email
        student.setEmail(updateStudentEmailRequestDto.getEmail());

        //saving student
        Student s = studentRepository.save(student);

        //creating response dto

        UpdateStudentEmailResponseDto updateStudentEmailResponseDto = new UpdateStudentEmailResponseDto();

        updateStudentEmailResponseDto.setEmail(s.getEmail());

        updateStudentEmailResponseDto.setDepartment(s.getDepartment());

        updateStudentEmailResponseDto.setName(s.getName());


        return updateStudentEmailResponseDto;




    }

    public GetStudentByAgeResponseDto getStudentsByAge(GetStudentByAgeRequestDto getStudentByAgeRequestDto){

        List<Student> students = studentRepository.findByAge(getStudentByAgeRequestDto.getAge());

        GetStudentByAgeResponseDto getStudentByAgeResponseDto = new GetStudentByAgeResponseDto();

        //setting list
        getStudentByAgeResponseDto.setStudents(students);

        return getStudentByAgeResponseDto;

    }



}
