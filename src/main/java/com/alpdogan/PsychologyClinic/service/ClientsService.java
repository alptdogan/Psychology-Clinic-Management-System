package com.alpdogan.PsychologyClinic.service;

import com.alpdogan.PsychologyClinic.entity.Clients;
import com.alpdogan.PsychologyClinic.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    public List<Clients> getAllClients() {
        return clientsRepository.findAll();
    }

    public Clients getClientById(int id) {
        return clientsRepository.findById(id);
    }

    public void createClient(Clients clients) {
        clientsRepository.save(clients);
    }

    public void updateClientById(int id, Clients clients) {
        clients.setId(id);
        clientsRepository.save(clients);
    }

    public void deleteClientById(int id) {
        clientsRepository.delete(clientsRepository.findById(id));
    }
}
