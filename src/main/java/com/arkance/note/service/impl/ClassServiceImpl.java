package com.arkance.note.service.impl;

import com.arkance.note.Repository.ClassRepository;
import com.arkance.note.domain.Class;
import com.arkance.note.service.ClassService;
import com.arkance.note.utils.dto.ClassDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClassServiceImpl implements ClassService {

    private ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public List<ClassDTO> getClassesAndPrincipalTeacher() {
        // map to classDTO
        List<ClassDTO>  classesDTO = classRepository.findAll()
                        .stream()
                        .map( c -> {
                            return new ClassDTO(c.getLevelName(), c.getTeacher().getFullName());
                        })
                        .collect(Collectors.toList());
        return classesDTO;
    }
}
