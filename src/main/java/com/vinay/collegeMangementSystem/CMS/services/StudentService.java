package com.vinay.collegeMangementSystem.CMS.services;

import com.vinay.collegeMangementSystem.CMS.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    StudentDto createNewStudent(StudentDto studentDto);

    StudentDto assignProfessorToStudent(Long studentId, Long professorId);

    List<StudentDto> getAllStudents();

    StudentDto assignSubjectToStudent(Long studentId, Long subjectId);
}
