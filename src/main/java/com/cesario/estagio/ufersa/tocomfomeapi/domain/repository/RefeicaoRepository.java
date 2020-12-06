package com.cesario.estagio.ufersa.tocomfomeapi.domain.repository;

import com.cesario.estagio.ufersa.tocomfomeapi.domain.enums.StatusRefeicao;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.enums.TipoRefeicao;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.models.Refeicao;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface RefeicaoRepository extends JpaRepository<Refeicao, Long> {
    long countByDataRefeicaoAndTipoRefeicaoAndStatusRefeicao
            (Date dataRefeicao, TipoRefeicao tipoRefeicao, StatusRefeicao statusRefeicao);
}
