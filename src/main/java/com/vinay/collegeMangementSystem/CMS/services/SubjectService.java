package com.vinay.collegeMangementSystem.CMS.services;

import com.vinay.collegeMangementSystem.CMS.dto.StudentDto;
import com.vinay.collegeMangementSystem.CMS.dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    SubjectDto createSubject(SubjectDto subjectDto);

    List<SubjectDto> getAllSubjects();

    StudentDto assignStudentToSubject(Long subjectId, Long studentId);

    SubjectDto assignProfessorToSubject(Long subjectId, Long professorId);
}

