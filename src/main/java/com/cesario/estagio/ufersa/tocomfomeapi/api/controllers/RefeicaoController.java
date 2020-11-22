package com.cesario.estagio.ufersa.tocomfomeapi.api.controllers;

import com.cesario.estagio.ufersa.tocomfomeapi.domain.enums.StatusRefeicao;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.models.Aluno;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.models.Refeicao;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.repository.AlunoRepository;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.repository.RefeicaoRepository;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.InvalidParameterException;
import java.util.Optional;

@Controller
@RequestMapping("/refeicoes")
public class RefeicaoController {

    private RefeicaoRepository refeicaoRepository;
    private AlunoRepository alunoRepository;

    public RefeicaoController(RefeicaoRepository refeicaoRepository, AlunoRepository alunoRepository){
        this.refeicaoRepository = refeicaoRepository;
        this.alunoRepository = alunoRepository;
    }

    @GetMapping("/solicitar")
    public String viewSolicitar(){
        return "refeicao/solicitar";
    }

    @PostMapping("/solicitar")
    public String Solicitar(Refeicao refeicao, HttpServletRequest httpServletRequest){
        long matricula = Long.parseLong(httpServletRequest.getParameter("matricula"));
        System.out.println("Eu sou a data" + refeicao.getDataRefeicao());
        Optional<Aluno> aluno = alunoRepository.findAlunoByMatricula(matricula);
        if (aluno.isPresent())
            refeicao.setAluno(aluno.get());
            refeicao.setStatusRefeicao(StatusRefeicao.ATIVA);
            refeicaoRepository.save(refeicao);
            return "redirect: refeicao/solicitar";
    }
}
