package com.cesario.estagio.ufersa.tocomfomeapi.api.controllers;

import com.cesario.estagio.ufersa.tocomfomeapi.domain.models.Refeicao;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.repository.RefeicaoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/refeicoes")
public class RefeicaoController {

    private RefeicaoRepository refeicaoRepository;

    public RefeicaoController(RefeicaoRepository refeicaoRepository){
        this.refeicaoRepository = refeicaoRepository;
    }

    @GetMapping("/solicitar")
    public String viewSolicitar(){
        return "refeicao/solicitar";
    }

    @PostMapping("/solicitar")
    public String Solicitar(Refeicao refeicao){

        refeicaoRepository.save(refeicao);
        return "redirect: /refeicoes/solicitar";
    }
}
