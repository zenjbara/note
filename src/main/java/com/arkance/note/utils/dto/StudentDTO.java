package com.arkance.note.utils.dto;

import com.arkance.note.utils.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class StudentDTO {
    private String firstName;

    private String lastName;

    private Gender gender;
}
