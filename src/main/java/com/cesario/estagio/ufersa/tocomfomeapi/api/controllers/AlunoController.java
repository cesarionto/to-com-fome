package com.cesario.estagio.ufersa.tocomfomeapi.api.controllers;

import com.cesario.estagio.ufersa.tocomfomeapi.domain.models.Aluno;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.services.implementation.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/index/administrativo/alunos")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public String save(Aluno aluno){
        alunoService.save(aluno);
        return "redirect:/index/administrativo";
    }
}
