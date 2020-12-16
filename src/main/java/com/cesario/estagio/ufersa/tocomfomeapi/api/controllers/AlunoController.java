package com.cesario.estagio.ufersa.tocomfomeapi.api.controllers;

import com.cesario.estagio.ufersa.tocomfomeapi.domain.models.Aluno;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.services.exceptions.RegraNegocioException;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.services.implementation.AlunoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index/administrativo/alunos")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public String save(Aluno aluno){
    	try {
        alunoService.save(aluno);
        return "redirect:/index/administrativo";
        }catch (RegraNegocioException e) {
			return "ERRORaoSalvarAluno";
		}
    }
}
