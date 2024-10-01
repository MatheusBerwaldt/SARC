package com.SARC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Professor {
    
    @Id
    @Getter
    @Setter
    @NotEmpty
    @Column(name="name")
    private String name;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;

}
