package com.vinay.collegeMangementSystem.CMS.services;

import com.vinay.collegeMangementSystem.CMS.dto.SubjectDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SubjectService {
    SubjectDto createSubject(SubjectDto subjectDto);

    List<SubjectDto> getAllSubjects();
}

