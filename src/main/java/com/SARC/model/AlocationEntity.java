package com.SARC.model;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "alocations")
public class AlocationEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int alocationId;

    @Column(name = "date_alocation", columnDefinition = "DATE")
    private LocalDate dateAlocation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TimeEntityEnum time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_class")
    private ClassEntity classes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_resource")
    private ResourceEntity resourceEntity;
}
