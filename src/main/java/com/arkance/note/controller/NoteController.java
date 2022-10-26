package com.arkance.note.controller;

import com.arkance.note.service.ClassService;
import com.arkance.note.utils.dto.ClassDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController {

    private ClassService classService;

    @Autowired
    public NoteController(ClassService classService) {
        this.classService = classService;
    }

    /**
     *
     * @return List of all classes and their principal teacher
     */
    @GetMapping("/classes")
    public List<ClassDTO> classesList(){

        return classService.getClassesAndPrincipalTeacher();
    }

}