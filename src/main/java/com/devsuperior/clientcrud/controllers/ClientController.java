package com.devsuperior.clientcrud.controllers;

import com.devsuperior.clientcrud.dtos.ClientDTO;
import com.devsuperior.clientcrud.services.ClientService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(
        @RequestParam (value = "page", defaultValue = "0") Integer page,
        @RequestParam (value = "linesPerPage", defaultValue = "5") Integer linesPerPage,
        @RequestParam (value = "orderBy", defaultValue = "name") String orderBy,
        @RequestParam (value = "direction", defaultValue = "ASC") String direction
    ) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        Page<ClientDTO> list = service.findAll(pageRequest);
        return ResponseEntity.ok().body(list);
    }
}
