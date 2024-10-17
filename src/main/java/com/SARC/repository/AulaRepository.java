package com.SARC.repository;

import com.SARC.domain.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {
    List<Aula> findByTurmaCodigo(Long turmaCodigo);
    boolean existsByTurmaCodigoAndDataAndHorario(Long turmaCodigo, LocalDate data, String horario);
}
