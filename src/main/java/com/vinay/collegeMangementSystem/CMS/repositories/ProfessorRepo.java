package com.vinay.collegeMangementSystem.CMS.repositories;

import com.vinay.collegeMangementSystem.CMS.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepo extends JpaRepository<ProfessorEntity, Long> {
}
