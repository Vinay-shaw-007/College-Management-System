package com.vinay.collegeMangementSystem.CMS.controllers;

import com.vinay.collegeMangementSystem.CMS.dto.ProfessorDto;
import com.vinay.collegeMangementSystem.CMS.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorDto>> getAllProfessors() {
        List<ProfessorDto> allProfessors = professorService.getAllProfessors();
        return ResponseEntity.ok(allProfessors);
    }

    @PostMapping
    public ResponseEntity<ProfessorDto> createProfessor(@RequestBody ProfessorDto professorDto) {
        ProfessorDto savedProfessor = professorService.createProfessor(professorDto);

        return new ResponseEntity<>(savedProfessor, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{professorId}/student/{studentId}")
    public ResponseEntity<ProfessorDto> assignStudentToProfessor(@PathVariable Long professorId,
                                                                 @PathVariable Long studentId) {
        ProfessorDto professorDto = professorService.assignStudentToProfessor(professorId, studentId);

        if (professorDto == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(professorDto);
    }

    @PutMapping(path = "/{professorId}/subject/{subjectId}")
    public ResponseEntity<ProfessorDto> assignSubjectToProfessor(@PathVariable Long professorId,
                                                                 @PathVariable Long subjectId) {
        ProfessorDto professorDto = professorService.assignSubjectToProfessor(professorId, subjectId);
        if (professorDto == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(professorDto);
    }
}
