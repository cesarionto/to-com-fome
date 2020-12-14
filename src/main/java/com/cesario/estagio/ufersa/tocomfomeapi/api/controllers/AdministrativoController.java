package com.cesario.estagio.ufersa.tocomfomeapi.api.controllers;

import com.cesario.estagio.ufersa.tocomfomeapi.domain.enums.StatusRefeicao;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.enums.TipoRefeicao;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.repository.RefeicaoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/index/administrativo")
public class AdministrativoController {

    private RefeicaoRepository refeicaoRepository;

    public AdministrativoController(RefeicaoRepository refeicaoRepository) {
        this.refeicaoRepository = refeicaoRepository;
    }

    @GetMapping
    public ModelAndView qtdAlmocoDia(){
        ModelAndView modelAndView = new ModelAndView("administrativo");
        Long almoco =  refeicaoRepository.countByDataRefeicaoAndTipoRefeicaoAndStatusRefeicao
                (LocalDate.now(), TipoRefeicao.ALMOCO, StatusRefeicao.ATIVA);
        Long jantar = refeicaoRepository.countByDataRefeicaoAndTipoRefeicaoAndStatusRefeicao
                (LocalDate.now(), TipoRefeicao.JANTAR, StatusRefeicao.ATIVA);
        modelAndView.addObject("almoco" ,
                almoco);
        modelAndView.addObject("jantar" ,
                jantar);
        System.out.println(almoco);
        System.out.println(jantar);
        return modelAndView;
    }
}
