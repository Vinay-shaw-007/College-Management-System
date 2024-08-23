package com.vinay.collegeMangementSystem.CMS.services.impl;

import com.vinay.collegeMangementSystem.CMS.dto.StudentDto;
import com.vinay.collegeMangementSystem.CMS.entities.ProfessorEntity;
import com.vinay.collegeMangementSystem.CMS.entities.StudentEntity;
import com.vinay.collegeMangementSystem.CMS.entities.SubjectEntity;
import com.vinay.collegeMangementSystem.CMS.repositories.ProfessorRepo;
import com.vinay.collegeMangementSystem.CMS.repositories.StudentRepo;
import com.vinay.collegeMangementSystem.CMS.repositories.SubjectRepo;
import com.vinay.collegeMangementSystem.CMS.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final ProfessorRepo professorRepo;
    private final SubjectRepo subjectRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<StudentEntity> studentList = studentRepo.findAll();

        return studentList
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public StudentDto createNewStudent(StudentDto studentDto) {
        StudentEntity studentEntity = convertToEntity(studentDto);
        return convertToDto(studentRepo.save(studentEntity));
    }

    @Override
    public StudentDto assignProfessorToStudent(Long studentId, Long professorId) {
        Optional<StudentEntity> studentEntity = studentRepo.findById(studentId);
        Optional<ProfessorEntity> professorEntity = professorRepo.findById(professorId);

        if (studentEntity.isEmpty() || professorEntity.isEmpty()) return null;

        studentEntity.get().getProfessors().add(professorEntity.get());
        return convertToDto(studentRepo.save(studentEntity.get()));
    }



    @Override
    public StudentDto assignSubjectToStudent(Long studentId, Long subjectId) {
        Optional<StudentEntity> studentEntity = studentRepo.findById(studentId);
        Optional<SubjectEntity> subjectEntity = subjectRepo.findById(subjectId);

        if (studentEntity.isEmpty() || subjectEntity.isEmpty()) return null;

        studentEntity.get().getSubjects().add(subjectEntity.get());
        return convertToDto(studentRepo.save(studentEntity.get()));
    }

    private StudentDto convertToDto(StudentEntity student) {
        return modelMapper.map(student, StudentDto.class);
    }

    private StudentEntity convertToEntity(StudentDto studentDto) {
        return modelMapper.map(studentDto, StudentEntity.class);
    }
}
