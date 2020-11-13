package com.cesario.estagio.ufersa.tocomfomeapi.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alunos")
@Getter @Setter @NoArgsConstructor
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "matricula", nullable = false)
    private long matricula;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @OneToMany(mappedBy = "aluno")
    private List<Refeicao> refeicoes = new ArrayList<>();

}