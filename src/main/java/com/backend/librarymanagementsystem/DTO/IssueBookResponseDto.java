package com.backend.librarymanagementsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class IssueBookResponseDto {

    private String recordNumber;
    private Date recordDate;

    private int cardId;

    private int bookId;



}
