package com.cesario.estagio.ufersa.tocomfomeapi.domain.services.implementation;

import com.cesario.estagio.ufersa.tocomfomeapi.domain.models.Aluno;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.repository.AlunoRepository;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.services.exceptions.RegraNegocioException;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.services.interfaces.AlunoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService implements AlunoServiceInterface {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @Override
    @Transactional
    public Aluno save(Aluno aluno) {
        validarMatricula(aluno.getMatricula());
        aluno.setNomeCompleto(aluno.getNomeCompleto().toUpperCase());
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno alterar(Aluno aluno) {
        validaId(aluno.getId());
        aluno.setNomeCompleto(aluno.getNomeCompleto().toUpperCase());
        return alunoRepository.save(aluno);
    }

    @Override
    public List<Aluno> index() {
        return alunoRepository.findAll();
    }

    @Override
    public void validarMatricula(long matricula) {
        boolean aluno = alunoRepository.existsByMatricula(matricula);
        if (aluno){
            throw new RegraNegocioException("Aluno já cadastrado na base de dados");
        }
    }

    @Override
    public void validaId(long id) {
        boolean aluno = alunoRepository.existsById(id);
        if(!aluno){
            throw new RegraNegocioException("Não Existe nenhum aluno com esse identificador");
        }
    }

}
