package com.cesario.estagio.ufersa.tocomfomeapi.api.controllers;

import com.cesario.estagio.ufersa.tocomfomeapi.domain.models.Aluno;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.repository.AlunoRepository;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.services.exceptions.RegraNegocioException;
import com.cesario.estagio.ufersa.tocomfomeapi.domain.services.implementation.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
@AllArgsConstructor
public class AlunoController {
    private AlunoService alunoService;
    private AlunoRepository alunoRepository;

    @PostMapping
    public ResponseEntity salvar(@RequestBody Aluno aluno){
        try{
            return new ResponseEntity(alunoService.save(aluno), HttpStatus.CREATED);
        }catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> index(){
        List<Aluno> alunos = alunoService.index();
        return ResponseEntity.ok(
                alunos
        );
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody Aluno aluno){
        try{
            return new ResponseEntity(alunoService.alterar(aluno), HttpStatus.CREATED);
        }catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id){
        if(!alunoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        alunoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
