package com.devsuperior.clientcrud.services;

import com.devsuperior.clientcrud.dtos.ClientDTO;
import com.devsuperior.clientcrud.entities.Client;
import com.devsuperior.clientcrud.exceptions.ResourceNotFoundException;
import com.devsuperior.clientcrud.repositories.ClientRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private static final String CLIENT_NOT_FOUND = "Client not found";
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(PageRequest pageRequest) {
        Page<Client> list = this.repository.findAll(pageRequest);
        return list.map(ClientDTO::new);
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(CLIENT_NOT_FOUND));
        return new ClientDTO(client);
    }

}
