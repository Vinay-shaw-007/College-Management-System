package com.vinay.collegeMangementSystem.CMS.services;

import com.vinay.collegeMangementSystem.CMS.dto.ProfessorDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProfessorService {
    ProfessorDto createProfessor(ProfessorDto professorDto);

    List<ProfessorDto> getAllProfessors();

    ProfessorDto assignStudentToProfessor(Long professorId, Long studentId);

    ProfessorDto assignSubjectToProfessor(Long professorId, Long subjectId);
}
