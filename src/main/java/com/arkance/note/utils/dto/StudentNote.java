package com.arkance.note.utils.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentNote {

    private String subjectName;

    private double note;
}
