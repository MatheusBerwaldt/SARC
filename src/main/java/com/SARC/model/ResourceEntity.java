package com.SARC.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resources")
public class ResourceEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codResource;

    @NonNull
    @Column(name = "description")
    private String description;

    @OneToMany
    private List<AlocationEntity> alocations;

    public ResourceEntity(Integer codResource, String description) {
        this.codResource = codResource;
        this.description = description;
    }
}
