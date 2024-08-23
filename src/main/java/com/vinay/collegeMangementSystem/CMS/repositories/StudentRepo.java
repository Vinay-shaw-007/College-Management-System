package com.vinay.collegeMangementSystem.CMS.repositories;

import com.vinay.collegeMangementSystem.CMS.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {
}
