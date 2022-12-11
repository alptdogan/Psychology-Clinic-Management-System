package com.alpdogan.PsychologyClinic.repository;

import com.alpdogan.PsychologyClinic.entity.TherapyApproach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TherapyApproachRepository extends JpaRepository<TherapyApproach, Integer> {

    TherapyApproach findById(int id);

}
