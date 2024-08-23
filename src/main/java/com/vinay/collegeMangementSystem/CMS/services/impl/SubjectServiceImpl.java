package com.vinay.collegeMangementSystem.CMS.services.impl;

import com.vinay.collegeMangementSystem.CMS.dto.SubjectDto;
import com.vinay.collegeMangementSystem.CMS.entities.SubjectEntity;
import com.vinay.collegeMangementSystem.CMS.repositories.SubjectRepo;
import com.vinay.collegeMangementSystem.CMS.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepo subjectRepo;
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
}
