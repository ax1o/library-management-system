package com.backend.librarymanagementsystem.Controller;


import com.backend.librarymanagementsystem.DTO.*;
import com.backend.librarymanagementsystem.Entity.Student;
import com.backend.librarymanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public UpdateStudentEmailResponseDto addStudent(@RequestBody CreateStudentRequestDto createStudentRequestDto){

        UpdateStudentEmailResponseDto updateStudentEmailResponseDto = studentService.addStudent(createStudentRequestDto);
        return updateStudentEmailResponseDto;

    }

    @PutMapping("/update-email")
    public UpdateStudentEmailResponseDto updateStudentEmail (@RequestBody UpdateStudentEmailRequestDto updateStudentEmailRequestDto){

        UpdateStudentEmailResponseDto updateStudentEmailResponseDto;
        try{
            updateStudentEmailResponseDto = studentService.updateStudentEmail(updateStudentEmailRequestDto);
        }catch (Exception e){
             System.out.println(e.getMessage());
             updateStudentEmailResponseDto = null;
             return updateStudentEmailResponseDto;
        }

        return updateStudentEmailResponseDto;

    }

    @GetMapping("/get-student-by-email")
    public UpdateStudentEmailResponseDto getStudentByEmail(@RequestBody UpdateStudentEmailRequestDto updateStudentEmailRequestDto){
        //as updateStudentEmailDto has 2 fields 1) email 2) id
        //we need the same 2 fields hence we are using this dto

        UpdateStudentEmailResponseDto updateStudentEmailResponseDto =  studentService.getStudentByEmail(updateStudentEmailRequestDto);

        return updateStudentEmailResponseDto;

    }

    @GetMapping("/get-students-by-age")
    public GetStudentByAgeResponseDto getStudentsByAge(@RequestBody GetStudentByAgeRequestDto getStudentByAgeRequestDto){

        GetStudentByAgeResponseDto getStudentByAgeResponseDto;

        try{
            getStudentByAgeResponseDto = studentService.getStudentsByAge(getStudentByAgeRequestDto);
        }catch (Exception e){
            getStudentByAgeResponseDto = null;
            System.out.println(e.getMessage());
            return getStudentByAgeResponseDto;
        }

        return getStudentByAgeResponseDto;

    }








}
