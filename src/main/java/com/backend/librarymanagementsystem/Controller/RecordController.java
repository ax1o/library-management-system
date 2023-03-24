package com.backend.librarymanagementsystem.Controller;

import com.backend.librarymanagementsystem.DTO.IssueBookRequestDto;
import com.backend.librarymanagementsystem.DTO.IssueBookResponseDto;
import com.backend.librarymanagementsystem.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    RecordService recordService;

    @PostMapping("/issue")
    public ResponseEntity issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {

        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        try{
             issueBookResponseDto = recordService.issueBook(issueBookRequestDto);
        }catch (Exception e){
            return new ResponseEntity("Failed",HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(issueBookResponseDto, HttpStatus.ACCEPTED);



    }


}
