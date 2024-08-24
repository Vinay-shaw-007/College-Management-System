package com.vinay.collegeMangementSystem.CMS.controllers;

import com.vinay.collegeMangementSystem.CMS.dto.StudentDto;
import com.vinay.collegeMangementSystem.CMS.dto.SubjectDto;
import com.vinay.collegeMangementSystem.CMS.entities.SubjectEntity;
import com.vinay.collegeMangementSystem.CMS.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<SubjectDto>> getAllSubjects() {
        List<SubjectDto> listOfSubjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(listOfSubjects);
    }

    @PostMapping
    public ResponseEntity<SubjectDto> createSubject(@RequestBody SubjectDto subjectDto) {
        SubjectDto savedSubject = subjectService.createSubject(subjectDto);

        return new ResponseEntity<>(savedSubject, HttpStatus.CREATED);
    }

    @PutMapping("/{subjectId}/professor/{professorId}")
    public ResponseEntity<SubjectDto> assignProfessorToSubject(@PathVariable Long subjectId,
                                                               @PathVariable Long professorId) {
        SubjectDto subjectDto = subjectService.assignProfessorToSubject(subjectId, professorId);

        if (subjectDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(subjectDto);
    }

    @PutMapping("/{subjectId}/student/{studentId}")
    public ResponseEntity<StudentDto> assignStudentToSubject(@PathVariable Long subjectId,
                                                             @PathVariable Long studentId) {
        StudentDto studentDto = subjectService.assignStudentToSubject(subjectId, studentId);

        if (studentDto == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(studentDto);
    }

}
