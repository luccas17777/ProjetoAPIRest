package com.ibm.SerasaProject.controller;

import com.ibm.SerasaProject.model.pessoa.Pessoa;
import com.ibm.SerasaProject.model.pessoa.PessoaRequest;
import com.ibm.SerasaProject.model.pessoa.PessoaResponse;
import com.ibm.SerasaProject.service.PessoaService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
