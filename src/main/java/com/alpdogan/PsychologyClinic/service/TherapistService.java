package com.alpdogan.PsychologyClinic.service;

import com.alpdogan.PsychologyClinic.entity.Therapist;
import com.alpdogan.PsychologyClinic.repository.TherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TherapistService {

    @Autowired
    private TherapistRepository therapistRepository;

    public List<Therapist> getAllTherapists() {
        return therapistRepository.findAll();
    }

    public Therapist getTherapistById(int id) {
        return therapistRepository.findById(id);
    }

    public void createTherapist(Therapist therapist) {
        therapistRepository.save(therapist);
    }

    public void updateTherapistById(int id, Therapist therapist) {
        therapist.setId(id);
        therapistRepository.save(therapist);
    }

    public void deleteTherapistById(int id) {
        therapistRepository.delete(therapistRepository.findById(id));
    }

}





















