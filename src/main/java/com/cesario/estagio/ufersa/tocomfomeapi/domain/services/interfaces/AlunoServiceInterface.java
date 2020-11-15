package com.cesario.estagio.ufersa.tocomfomeapi.domain.services.interfaces;

import com.cesario.estagio.ufersa.tocomfomeapi.domain.models.Aluno;

import java.util.List;
import java.util.Optional;

public interface AlunoServiceInterface {
    public Aluno save(Aluno aluno);
    public void deletar(long id);
    public Aluno alterar(long id);
    public List<Aluno> index();
    public void validarMatricula(long matricula);
}
