package com.cesario.estagio.ufersa.tocomfomeapi.services.implementation;

import com.cesario.estagio.ufersa.tocomfomeapi.domain.models.Aluno;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.repository.AlunoRepository;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.services.exceptions.RegraNegocioException;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.services.implementation.AlunoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class AlunoServiceTeste {

    @Autowired
    AlunoService alunoService;

    @Autowired
    AlunoRepository alunoRepository;

    @Test
    public void deveValidarMatricula(){
        alunoRepository.deleteAll();
        alunoService.validarMatricula(2016021154);
    }

    @Test
    public void deveLancarExceptionAoValidarMatricula() throws RegraNegocioException{
        Aluno aluno = new Aluno();
        aluno.setNomeCompleto("Cesário Pereira Neto");
        aluno.setMatricula(2016021154);
        alunoRepository.save(aluno);
        Exception exception = assertThrows(RegraNegocioException.class,
                ()-> {
                    alunoService.validarMatricula(2016021154);
                });
    }

    @Test
    public void deveValidarId(){
        alunoRepository.deleteAll();
        Aluno aluno = new Aluno();
        aluno.setMatricula(2016021154);
        aluno.setNomeCompleto("Cesário Pereira Neto");
        alunoRepository.save(aluno);
        alunoService.validaId(1);
    }

    @Test
    public void deveLancarExceptionSeAlunoNaoExistirPorId() throws RegraNegocioException{
        alunoRepository.deleteAll();
        Aluno aluno = new Aluno();
        aluno.setMatricula(2016021154);
        aluno.setNomeCompleto("Cesário Pereira Neto");
        alunoRepository.save(aluno);

        Exception exception = assertThrows(RegraNegocioException.class, ()->{
            alunoService.validaId(2);
        });
    }

}
