package com.vinay.collegeMangementSystem.CMS.services.impl;

import com.vinay.collegeMangementSystem.CMS.dto.AdmissionRecordDto;
import com.vinay.collegeMangementSystem.CMS.entities.AdmissionRecordEntity;
import com.vinay.collegeMangementSystem.CMS.entities.StudentEntity;
import com.vinay.collegeMangementSystem.CMS.repositories.AdmissionRecordRepo;
import com.vinay.collegeMangementSystem.CMS.repositories.StudentRepo;
import com.vinay.collegeMangementSystem.CMS.services.AdmissionRecordService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdmissionRecordServiceImpl implements AdmissionRecordService {

    private final AdmissionRecordRepo admissionRecordRepo;
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    @Override
    public AdmissionRecordDto createAdmissionRecordForStudent(AdmissionRecordDto admissionRecordDto, Long studentId) {
        AdmissionRecordEntity admissionRecord = modelMapper.map(admissionRecordDto, AdmissionRecordEntity.class);
        Optional<StudentEntity> student = studentRepo.findById(studentId);
        return student.map(studentEntity -> {
            admissionRecord.setStudent(studentEntity);
            return modelMapper.map(admissionRecordRepo.save(admissionRecord), AdmissionRecordDto.class);
        }).orElse(null);
    }

    @Override
    public List<AdmissionRecordDto> getAllAdmissionRecords() {
        List<AdmissionRecordEntity> list = admissionRecordRepo.findAll();
        return list
                .stream()
                .map(record -> modelMapper.map(record, AdmissionRecordDto.class))
                .toList();
    }
}
