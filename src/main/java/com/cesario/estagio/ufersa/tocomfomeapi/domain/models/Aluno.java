package com.cesario.estagio.ufersa.tocomfomeapi.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "alunos")
@Getter @Setter @NoArgsConstructor
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "matricula", nullable = false)
    private long matricula;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

}