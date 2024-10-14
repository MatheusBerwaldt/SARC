package com.SARC.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "resources")
public class ResourceEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codResource;

    @Column(name = "description")
    private String Description;

    public int getCodResource() {
        return codResource;
    }

    public void setCodResource(int codResource) {
        this.codResource = codResource;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
