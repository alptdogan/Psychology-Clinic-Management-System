package com.alpdogan.PsychologyClinic.service;

import com.alpdogan.PsychologyClinic.entity.Modality;
import com.alpdogan.PsychologyClinic.repository.ModalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModalityService {

    @Autowired
    private ModalityRepository modalityRepository;

    public List<Modality> getAllModalities() {
        return modalityRepository.findAll();
    }

    public Modality getModalityById(int id) {
        return modalityRepository.findById(id);
    }

    public void createModality(Modality modality) {
        modalityRepository.save(modality);
    }

    public void updateModalityById(int id, Modality modality) {
        modality.setId(id);
        modalityRepository.save(modality);
    }

    public void deleteModalityById(int id) {
        modalityRepository.delete(modalityRepository.findById(id));
    }

}
