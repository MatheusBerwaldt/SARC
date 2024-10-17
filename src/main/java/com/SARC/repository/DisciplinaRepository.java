package com.SARC.repository;

import com.SARC.domain.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, String> {
    boolean existsByCodigo(String codigo);
}
