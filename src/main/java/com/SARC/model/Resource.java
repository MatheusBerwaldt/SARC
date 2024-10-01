package com.SARC.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

public class Resource {
    
    @Id
    @ManyToOne
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codResource;

    @Getter
    @Setter
    @Column(name = "description")
    private String Description;
}
