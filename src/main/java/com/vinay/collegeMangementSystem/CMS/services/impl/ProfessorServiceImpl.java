package com.vinay.collegeMangementSystem.CMS.services.impl;

import com.vinay.collegeMangementSystem.CMS.dto.ProfessorDto;
import com.vinay.collegeMangementSystem.CMS.entities.ProfessorEntity;
import com.vinay.collegeMangementSystem.CMS.entities.StudentEntity;
import com.vinay.collegeMangementSystem.CMS.entities.SubjectEntity;
import com.vinay.collegeMangementSystem.CMS.repositories.ProfessorRepo;
import com.vinay.collegeMangementSystem.CMS.repositories.StudentRepo;
import com.vinay.collegeMangementSystem.CMS.repositories.SubjectRepo;
import com.vinay.collegeMangementSystem.CMS.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepo professorRepo;
    private final StudentRepo studentRepo;
    private final SubjectRepo subjectRepo;
    private final ModelMapper modelMapper;

    @Override
    public ProfessorDto createProfessor(ProfessorDto professorDto) {
        ProfessorEntity professor = modelMapper.map(professorDto, ProfessorEntity.class);
        return modelMapper.map(professorRepo.save(professor), ProfessorDto.class);
    }

    @Override
    public List<ProfessorDto> getAllProfessors() {
        List<ProfessorEntity> allProfessors = professorRepo.findAll();
        return allProfessors
                .stream()
                .map(professor -> modelMapper.map(professor, ProfessorDto.class))
                .toList();
    }

    @Override
    public ProfessorDto assignStudentToProfessor(Long professorId, Long studentId) {
        Optional<ProfessorEntity> professorEntity = professorRepo.findById(professorId);
        Optional<StudentEntity> studentEntity = studentRepo.findById(studentId);

        if (professorEntity.isEmpty() || studentEntity.isEmpty()) return null;

        professorEntity.get().getStudents().add(studentEntity.get());
        return modelMapper.map(professorRepo.save(professorEntity.get()), ProfessorDto.class);
    }

    @Override
    public ProfessorDto assignSubjectToProfessor(Long professorId, Long subjectId) {
        Optional<ProfessorEntity> professorEntity = professorRepo.findById(professorId);
        Optional<SubjectEntity> subjectEntity = subjectRepo.findById(subjectId);

        if (professorEntity.isEmpty() || subjectEntity.isEmpty()) return null;

        professorEntity.get().getSubjects().add(subjectEntity.get());
        return modelMapper.map(professorRepo.save(professorEntity.get()), ProfessorDto.class);
    }
}
