package com.devsuperior.clientcrud.services;

import com.devsuperior.clientcrud.dtos.ClientDTO;
import com.devsuperior.clientcrud.entities.Client;
import com.devsuperior.clientcrud.repositories.ClientRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public Page<ClientDTO> findAll(PageRequest pageRequest) {
        Page<Client> list = this.repository.findAll(pageRequest);
        return list.map(ClientDTO::new);
    }

}
