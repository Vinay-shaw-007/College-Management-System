package com.vinay.collegeMangementSystem.CMS.repositories;

import com.vinay.collegeMangementSystem.CMS.entities.AdmissionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordRepo extends JpaRepository<AdmissionRecordEntity, Long> {
}
