package com.example.spring.test.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.naming.factory.SendMailFactory;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@IdClass(UserId.class)
public class User
{
    @Id
    @NotNull
    private String name;
    @Id
    @NotNull
    private String lastName;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Address address;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Phone> phones;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="email_id", nullable=false, unique = true)
    private Email email;
}
