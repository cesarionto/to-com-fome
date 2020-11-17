package com.cesario.estagio.ufersa.tocomfomeapi.domain.repository;

import com.cesario.estagio.ufersa.tocomfomeapi.domain.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    //Optional<Aluno> findAlunoByMatricula(Long matricula);

    boolean existsByMatricula(long matricula);
    boolean existsById(long id);
}
