package com.vinay.collegeMangementSystem.CMS.services.impl;

import com.vinay.collegeMangementSystem.CMS.dto.ProfessorDto;
import com.vinay.collegeMangementSystem.CMS.entities.ProfessorEntity;
import com.vinay.collegeMangementSystem.CMS.repositories.ProfessorRepo;
import com.vinay.collegeMangementSystem.CMS.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepo professorRepo;
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
}
