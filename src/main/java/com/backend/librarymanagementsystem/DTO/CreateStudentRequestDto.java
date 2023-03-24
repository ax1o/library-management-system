package com.backend.librarymanagementsystem.DTO;

import com.backend.librarymanagementsystem.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateStudentRequestDto {

    private String name;
    private int age;
    private Department department;
    private String email;

}
