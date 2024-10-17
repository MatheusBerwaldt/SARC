package com.SARC.repository;

import com.SARC.domain.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    List<Turma> findByDisciplinaCodigo(Long codigoDisciplina);
    boolean existsByCodigoAndDisciplinaCodigo(Long codigo, Long codigoDisciplina);
}
