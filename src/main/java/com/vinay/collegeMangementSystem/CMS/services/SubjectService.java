package com.vinay.collegeMangementSystem.CMS.services;

import com.vinay.collegeMangementSystem.CMS.dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    SubjectDto createSubject(SubjectDto subjectDto);

    List<SubjectDto> getAllSubjects();

    SubjectDto assignStudentToSubject(Long subjectId, Long studentId);

    SubjectDto assignProfessorToSubject(Long subjectId, Long professorId);
}

