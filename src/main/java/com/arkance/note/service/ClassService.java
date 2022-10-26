package com.arkance.note.service;

import com.arkance.note.utils.dto.ClassDTO;

import java.util.List;

public interface ClassService {

    List<ClassDTO> getClassesAndPrincipalTeacher();

}
