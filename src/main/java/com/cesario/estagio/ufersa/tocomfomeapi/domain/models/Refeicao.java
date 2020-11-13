package com.cesario.estagio.ufersa.tocomfomeapi.domain.models;

import com.cesario.estagio.ufersa.tocomfomeapi.domain.enums.Campi;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.enums.TipoRefeicao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@Table(name = "tb_refeicoes")
@Getter @Setter @NoArgsConstructor
public class Refeicao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_refeicao")
    private TipoRefeicao tipoRefeicao;

    @Column(name = "data_refeicao")
    private OffsetDateTime dataRefeicao;

    @Column(name = "campi")
    private Campi campi;
}
