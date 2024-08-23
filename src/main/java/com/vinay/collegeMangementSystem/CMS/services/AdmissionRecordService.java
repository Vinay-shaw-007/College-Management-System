package com.vinay.collegeMangementSystem.CMS.services;

import com.vinay.collegeMangementSystem.CMS.dto.AdmissionRecordDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdmissionRecordService {
    AdmissionRecordDto createAdmissionRecordForStudent(AdmissionRecordDto admissionRecordDto, Long studentId);

    List<AdmissionRecordDto> getAllAdmissionRecords();
}
