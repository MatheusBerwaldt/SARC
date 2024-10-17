package com.SARC.repository;

import com.SARC.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByData(LocalDate data);
    List<Reserva> findByTurmaCodigo(Long turmaCodigo);
    boolean existsByRecursoCodigoAndDataAndHorario(Long recursoCodigo, LocalDate data, String horario);
    boolean existsByTurmaProfessorIdAndDataAndHorario(Long professorId, LocalDate data, String horario);
}
