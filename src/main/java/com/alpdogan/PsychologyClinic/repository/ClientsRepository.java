package com.alpdogan.PsychologyClinic.repository;

import com.alpdogan.PsychologyClinic.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Integer> {

    Clients findById(int id);

}