package com.cesario.estagio.ufersa.tocomfomeapi.domain.models;

import com.cesario.estagio.ufersa.tocomfomeapi.domain.enums.Campi;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.enums.StatusRefeicao;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.enums.TipoRefeicao;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "refeicoes")
public class Refeicao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_refeicao")
    private TipoRefeicao tipoRefeicao;

    @Column(name = "data_refeicao")
    private LocalDate dataRefeicao;

    @Enumerated(EnumType.STRING)
    @Column(name = "campi")
    private Campi campi;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_refeicao")
    private StatusRefeicao statusRefeicao;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    public Refeicao() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TipoRefeicao getTipoRefeicao() {
        return tipoRefeicao;
    }

    public void setTipoRefeicao(TipoRefeicao tipoRefeicao) {
        this.tipoRefeicao = tipoRefeicao;
    }

    public LocalDate getDataRefeicao() {
		return dataRefeicao;
	}

	public void setDataRefeicao(LocalDate dataRefeicao) {
		this.dataRefeicao = dataRefeicao;
	}

	public Campi getCampi() {
        return campi;
    }

    public void setCampi(Campi campi) {
        this.campi = campi;
    }

    public StatusRefeicao getStatusRefeicao() {
        return statusRefeicao;
    }

    public void setStatusRefeicao(StatusRefeicao statusRefeicao) {
        this.statusRefeicao = statusRefeicao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
