package com.arkance.note.utils.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClassAndStudentDTO {

    private String levelName;

    private List<String> studentsFullName;
}
