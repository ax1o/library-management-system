package com.backend.librarymanagementsystem.DTO;


import com.backend.librarymanagementsystem.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateStudentEmailResponseDto {

    private String name;
    private String email;

    private Department department;

}
