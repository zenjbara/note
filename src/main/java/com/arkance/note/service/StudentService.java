package com.arkance.note.service;

import com.arkance.note.utils.dto.StudentNote;

import java.util.List;

public interface StudentService {

    List<StudentNote> getStudentNotesBySubject(Long studentId);

}
