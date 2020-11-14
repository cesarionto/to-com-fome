package com.cesario.estagio.ufersa.tocomfomeapi.domain.repository;

import com.cesario.estagio.ufersa.tocomfomeapi.domain.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
