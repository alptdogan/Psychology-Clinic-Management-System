package com.alpdogan.PsychologyClinic.service;

import com.alpdogan.PsychologyClinic.entity.TherapyApproach;
import com.alpdogan.PsychologyClinic.repository.TherapyApproachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TherapyApproachService {

    @Autowired
    private TherapyApproachRepository therapyApproachRepository;

    public List<TherapyApproach> getAllApproaches() {
        return therapyApproachRepository.findAll();
    }

    public TherapyApproach getApproachById(int id) {
        return therapyApproachRepository.findById(id);
    }

    public void createApproach(TherapyApproach therapyApproach) {
        therapyApproachRepository.save(therapyApproach);
    }

    public void updateApproachById(int id, TherapyApproach therapyApproach) {
        therapyApproach.setId(id);
        therapyApproachRepository.save(therapyApproach);
    }

    public void deleteApproachById(int id) {
        therapyApproachRepository.delete(therapyApproachRepository.findById(id));
    }
}
