package com.arkance.note.service.impl;

import com.arkance.note.Repository.TeacherRepository;
import com.arkance.note.domain.Teacher;
import com.arkance.note.service.TeacherService;
import com.arkance.note.utils.dto.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<TeacherDTO> getTeachersAndSubjects() {

        List<Teacher> teachers = teacherRepository.findAll();

        // map to teacherDTO
        return teachers.stream()
                .map(teacher -> {
                    String subjectName = teacher.getSubject() != null ? teacher.getSubject().getName() : null;
                    return new TeacherDTO(teacher.getFullName(), subjectName);
                })
                .collect(Collectors.toList());
    }
}
