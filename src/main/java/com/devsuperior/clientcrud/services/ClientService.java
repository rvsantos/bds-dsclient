package com.devsuperior.clientcrud.services;

import javax.persistence.EntityNotFoundException;

import com.devsuperior.clientcrud.dtos.ClientDTO;
import com.devsuperior.clientcrud.entities.Client;
import com.devsuperior.clientcrud.exceptions.ResourceNotFoundException;
import com.devsuperior.clientcrud.repositories.ClientRepository;

import org.springframework.dao.EmptyResultDataAccessException;
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

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = clientDTO.toClient();
        return new ClientDTO(this.repository.save(client));
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        try {
            Client client = this.repository.getById(id);
            var clientSaved = this.repository.save(clientDTO.copyDtoToClient(client));
            return new ClientDTO(clientSaved);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(CLIENT_NOT_FOUND);
        }
    }

    public void delete(Long id) {
        try {
            this.repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(CLIENT_NOT_FOUND);
        }
    }
}
