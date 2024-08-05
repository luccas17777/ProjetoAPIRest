package com.ibm.SerasaProject.service;

import com.ibm.SerasaProject.feing.ViaCepClient;
import com.ibm.SerasaProject.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private ViaCepClient viaCepClient;
    @Autowired
    private PessoaRepository pessoaRepository;



}
