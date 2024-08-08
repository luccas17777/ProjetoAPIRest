package com.ibm.SerasaProject.controller;

import com.ibm.SerasaProject.model.pessoa.Pessoa;
import com.ibm.SerasaProject.model.pessoa.PessoaRequest;
import com.ibm.SerasaProject.model.pessoa.PessoaResponse;
import com.ibm.SerasaProject.service.PessoaService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pessoas/")
public class PessoaController {
    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    @PostMapping("criar")
    public ResponseEntity criarPessoa(@RequestBody PessoaRequest pessoaRequest){
        pessoaService.criarPessoa(pessoaRequest);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("buscar/{nome}/{cep}/{idade}")
    public ResponseEntity<List<PessoaResponse>> buscarPessoas(@PathVariable String nome, @PathVariable Integer idade, @PathVariable String cep){
        return ResponseEntity.ok(pessoaService.listarPessoas(nome, cep, idade));
    }

}
