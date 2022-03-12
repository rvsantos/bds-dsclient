
package com.devsuperior.clientcrud.dtos;

import java.io.Serializable;
import java.time.Instant;

import com.devsuperior.clientcrud.entities.Client;

public class ClientDTO implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private Integer children;
    private Instant birthDate;

    private ClientDTO() {
    }

    public ClientDTO(Long id, String name, String cpf, Double income, Integer children, Instant birthDate) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.children = children;
        this.birthDate = birthDate;
    }

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.income = client.getIncome();
        this.children = client.getChildren();
        this.birthDate = client.getBirthDate();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public Client toClient() {
        return new Client.ClientBuilder()
                .name(this.getName())
                .cpf(this.getCpf())
                .income(this.getIncome())
                .children(this.getChildren())
                .birthDate(birthDate)
                .build();
    }

    public Client copyDtoToClient(Client client) {
        client.setName(this.name);
        client.setBirthDate(this.birthDate);
        client.setIncome(income);
        client.setCpf(cpf);
        client.setChildren(children);
        return client;
    }
}
