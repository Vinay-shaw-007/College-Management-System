package com.vinay.collegeMangementSystem.CMS.repositories;

import com.vinay.collegeMangementSystem.CMS.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<SubjectEntity, Long> {
}
