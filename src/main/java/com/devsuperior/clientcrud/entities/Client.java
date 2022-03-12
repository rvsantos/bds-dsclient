package com.devsuperior.clientcrud.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {
    private static final Long serialVersionUID = 1L;
    private static final String TIMESTAMP_WITHOUT_TIME_ZONE = "TIMESTAMP WITHOUT TIME ZONE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private Integer children;

    @Column(columnDefinition = TIMESTAMP_WITHOUT_TIME_ZONE)
    private Instant birthDate;

    @Column(columnDefinition = TIMESTAMP_WITHOUT_TIME_ZONE)
    private Instant createdAt;

    @Column(columnDefinition = TIMESTAMP_WITHOUT_TIME_ZONE)
    private Instant updatedAt;

    private Client() {
    }

    private Client(Long id, String name, String cpf, Double income, Instant birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
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

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = Instant.now();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public static class ClientBuilder {
        private Long id;
        private String name;
        private String cpf;
        private Double income;
        private Integer children;
        private Instant birthDate;

        public ClientBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ClientBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ClientBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public ClientBuilder income(Double income) {
            this.income = income;
            return this;
        }

        public ClientBuilder children(Integer children) {
            this.children = children;
            return this;
        }

        public ClientBuilder birthDate(Instant birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Client build() {
            return new Client(id, name, cpf, income, birthDate, children);
        }
    }
}
