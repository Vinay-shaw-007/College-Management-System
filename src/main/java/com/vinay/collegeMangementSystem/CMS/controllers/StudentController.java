package com.vinay.collegeMangementSystem.CMS.controllers;

import com.vinay.collegeMangementSystem.CMS.dto.StudentDto;
import com.vinay.collegeMangementSystem.CMS.services.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> studentList = studentService.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody StudentDto studentDto) {
        StudentDto savedStudent = studentService.createNewStudent(studentDto);

        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{studentId}/professor/{professorId}")
    public ResponseEntity<StudentDto> assignProfessorToStudent(@PathVariable Long studentId,
                                                        @PathVariable Long professorId) {
        StudentDto student = studentService.assignProfessorToStudent(studentId, professorId);
        log.info("Assigning professor {} to student {}", professorId, studentId); // Add this line

        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(student);
    }

    @PutMapping(path = "/{studentId}/subject/{subjectId}")
    public ResponseEntity<StudentDto> assignSubjectToStudent(@PathVariable Long studentId,
                                                             @PathVariable Long subjectId) {
        StudentDto student = studentService.assignSubjectToStudent(studentId, subjectId);
        if (student == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(student);
    }
}
