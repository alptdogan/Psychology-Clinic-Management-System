package com.alpdogan.PsychologyClinic.repository;

import com.alpdogan.PsychologyClinic.entity.Therapist;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TherapistRepository extends JpaRepository<Therapist, Integer> {

    Therapist findById(int id);

}
