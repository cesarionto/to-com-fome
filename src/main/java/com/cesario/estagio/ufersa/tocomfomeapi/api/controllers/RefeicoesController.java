package com.cesario.estagio.ufersa.tocomfomeapi.api.controllers;

import com.cesario.estagio.ufersa.tocomfomeapi.domain.models.Refeicao;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.repository.RefeicaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Ref;
import java.util.List;

@RestController
@RequestMapping("/refeicoes")
@AllArgsConstructor
public class RefeicoesController {
    private RefeicaoRepository refeicaoRepository;

    @GetMapping
    public ResponseEntity<List<Refeicao>> index(){
        return ResponseEntity.ok(refeicaoRepository.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Refeicao> add(@RequestBody Refeicao refeicao){
        return new ResponseEntity<Refeicao>(refeicaoRepository.save(refeicao), HttpStatus.CREATED);
    }



}
