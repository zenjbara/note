package com.arkance.note.service.impl;

import com.arkance.note.Repository.StudentRepository;
import com.arkance.note.domain.Student;
import com.arkance.note.service.StudentService;
import com.arkance.note.utils.dto.StudentNote;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentNote> getStudentNotesBySubject(Long studentId) {
        List<StudentNote> studentNotes = new ArrayList<>();
        Student student = studentRepository.findById(studentId)
                        .orElseThrow(() -> new RuntimeException("Student with id " + studentId + " not found"));

        student.getNotes().forEach(note -> {
            studentNotes.add(new StudentNote(note.getSubject().getName(), note.getResult()));
        });

        return studentNotes;
    }
}
