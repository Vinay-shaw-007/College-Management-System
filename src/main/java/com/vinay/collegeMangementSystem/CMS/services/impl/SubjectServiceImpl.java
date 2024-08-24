package com.vinay.collegeMangementSystem.CMS.services.impl;

import com.vinay.collegeMangementSystem.CMS.dto.SubjectDto;
import com.vinay.collegeMangementSystem.CMS.entities.ProfessorEntity;
import com.vinay.collegeMangementSystem.CMS.entities.StudentEntity;
import com.vinay.collegeMangementSystem.CMS.entities.SubjectEntity;
import com.vinay.collegeMangementSystem.CMS.repositories.ProfessorRepo;
import com.vinay.collegeMangementSystem.CMS.repositories.StudentRepo;
import com.vinay.collegeMangementSystem.CMS.repositories.SubjectRepo;
import com.vinay.collegeMangementSystem.CMS.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepo subjectRepo;
    private final ProfessorRepo professorRepo;
    private final StudentRepo studentRepo;

    private final ModelMapper modelMapper;

    @Override
    public SubjectDto createSubject(SubjectDto subjectDto) {
        SubjectEntity subject = modelMapper.map(subjectDto, SubjectEntity.class);
        return modelMapper.map(subjectRepo.save(subject), SubjectDto.class);
    }

    @Override
    public List<SubjectDto> getAllSubjects() {
        List<SubjectEntity> allSubjects = subjectRepo.findAll();
        return allSubjects
                .stream()
                .map(subject -> modelMapper.map(subject, SubjectDto.class))
                .toList();
    }

    @Override
    public SubjectDto assignStudentToSubject(Long subjectId, Long studentId) {
        Optional<SubjectEntity> subjectEntity = subjectRepo.findById(subjectId);
        Optional<StudentEntity> studentEntity = studentRepo.findById(studentId);

        if (subjectEntity.isEmpty() || studentEntity.isEmpty()) return null;
        subjectEntity.get().getStudents().add(studentEntity.get());
        return modelMapper.map(subjectRepo.save(subjectEntity.get()), SubjectDto.class);
    }

    @Override
    public SubjectDto assignProfessorToSubject(Long subjectId, Long professorId) {
        Optional<SubjectEntity> subjectEntity = subjectRepo.findById(subjectId);
        Optional<ProfessorEntity> professorEntity = professorRepo.findById(professorId);

        if (subjectEntity.isEmpty() || professorEntity.isEmpty()) return null;
        subjectEntity.get().setProfessor(professorEntity.get());
        return modelMapper.map(subjectRepo.save(subjectEntity.get()), SubjectDto.class);
    }
}
