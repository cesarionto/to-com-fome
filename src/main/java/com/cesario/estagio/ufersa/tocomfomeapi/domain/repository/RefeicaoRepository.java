package com.cesario.estagio.ufersa.tocomfomeapi.domain.repository;

import com.cesario.estagio.ufersa.tocomfomeapi.domain.models.Refeicao;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RefeicaoRepository extends JpaRepository<Refeicao, Long> {
}
