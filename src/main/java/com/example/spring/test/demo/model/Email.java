package com.example.spring.test.demo.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Data
@Entity
class Email
{
    @Id
    @javax.validation.constraints.Email
    private String email;
}
