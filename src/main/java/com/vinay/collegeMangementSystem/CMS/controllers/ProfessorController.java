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
}
