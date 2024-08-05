package com.ibm.SerasaProject.service;

import com.ibm.SerasaProject.dto.PessoaDTO;
import com.ibm.SerasaProject.feing.ViaCepClient;
import com.ibm.SerasaProject.model.Endereco;
import com.ibm.SerasaProject.model.pessoa.Pessoa;
import com.ibm.SerasaProject.model.pessoa.PessoaRequest;
import com.ibm.SerasaProject.model.pessoa.PessoaResponse;
import com.ibm.SerasaProject.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private ViaCepClient viaCepClient;
    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaService(ViaCepClient viaCepClient, PessoaRepository pessoaRepository){
        this.viaCepClient = viaCepClient;
        this.pessoaRepository = pessoaRepository;
    }

    public void criarPessoa(PessoaRequest pessoaRequest){
        Endereco endereco = viaCepClient.buscarEnderecoPorCep(pessoaRequest.getCep());
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaRequest.getNome());
        pessoa.setCep(pessoaRequest.getCep());
        pessoa.setScore(pessoaRequest.getScore());
        pessoa.setIdade(pessoaRequest.getIdade());
        pessoa.setTelefone(pessoa.getTelefone());
        pessoa.setLogradouro(endereco.getLogradouro());
        pessoa.setEstado(endereco.getUf());
        pessoa.setCidade(endereco.getLocalidade());
        pessoa.setBairro(endereco.getBairro());
        pessoaRepository.save(pessoa);

    }

}
