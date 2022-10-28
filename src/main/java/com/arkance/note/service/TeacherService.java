package com.arkance.note.service;

import com.arkance.note.utils.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {

    List<TeacherDTO> getTeachersAndSubjects();

}
