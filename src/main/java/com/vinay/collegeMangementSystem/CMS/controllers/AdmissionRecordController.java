package com.vinay.collegeMangementSystem.CMS.controllers;

import com.vinay.collegeMangementSystem.CMS.dto.AdmissionRecordDto;
import com.vinay.collegeMangementSystem.CMS.services.AdmissionRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/admissionRecord")
public class AdmissionRecordController {

    private final AdmissionRecordService admissionRecordService;

    @GetMapping
    public ResponseEntity<List<AdmissionRecordDto>> getAllAdmissionRecords() {
        List<AdmissionRecordDto> admissionRecordList = admissionRecordService.getAllAdmissionRecords();
        return ResponseEntity.ok(admissionRecordList);
    }

    @PostMapping(path = "/{studentId}")
    public ResponseEntity<AdmissionRecordDto> createAdmissionRecordForStudent(@RequestBody AdmissionRecordDto admissionRecordDto,
                                                                              @PathVariable Long studentId) {
        AdmissionRecordDto savedAdmissionRecord = admissionRecordService.createAdmissionRecordForStudent(admissionRecordDto, studentId);

        return new ResponseEntity<>(savedAdmissionRecord, HttpStatus.CREATED);

    }
}
