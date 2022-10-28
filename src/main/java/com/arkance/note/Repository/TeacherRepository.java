package com.arkance.note.Repository;

import com.arkance.note.domain.Teacher;
import com.arkance.note.utils.dto.TeacherDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {}