package com.cesario.estagio.ufersa.tocomfomeapi.api.controllers;

import com.cesario.estagio.ufersa.tocomfomeapi.domain.enums.StatusRefeicao;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.enums.TipoRefeicao;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.repository.RefeicaoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/index/administrativo")
public class AdministrativoController {

    private RefeicaoRepository refeicaoRepository;

    public AdministrativoController(RefeicaoRepository refeicaoRepository) {
        this.refeicaoRepository = refeicaoRepository;
    }

    @GetMapping
    public ModelAndView qtdAlmocoDia(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);
        ModelAndView modelAndView = new ModelAndView("administrativo");
        Long almoco = refeicaoRepository.countByDataRefeicaoAndTipoRefeicaoAndStatusRefeicao
                (date, TipoRefeicao.ALMOCO, StatusRefeicao.ATIVA);
        Long jantar = refeicaoRepository.countByDataRefeicaoAndTipoRefeicaoAndStatusRefeicao
                (date, TipoRefeicao.JANTA, StatusRefeicao.ATIVA);
        modelAndView.addObject("almoco" ,
                almoco);
        modelAndView.addObject("jantar" ,
                jantar);
        return modelAndView;
    }
}
