package com.ibm.SerasaProject.service;

import com.ibm.SerasaProject.dto.PessoaDTO;
import com.ibm.SerasaProject.feing.ViaCepClient;
import com.ibm.SerasaProject.mapper.Mapper;
import com.ibm.SerasaProject.model.Endereco;
import com.ibm.SerasaProject.model.pessoa.Pessoa;
import com.ibm.SerasaProject.model.pessoa.PessoaRequest;
import com.ibm.SerasaProject.model.pessoa.PessoaResponse;
import com.ibm.SerasaProject.repository.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private ViaCepClient viaCepClient;
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private Mapper modelMapper;

    public PessoaService(ViaCepClient viaCepClient, PessoaRepository pessoaRepository){
        this.viaCepClient = viaCepClient;
        this.pessoaRepository = pessoaRepository;
    }

    public void criarPessoa(PessoaRequest pessoaRequest){
        PessoaDTO pessoaDTO = modelMapper.RequestToDto(pessoaRequest);
        Endereco endereco = viaCepClient.buscarEnderecoPorCep(pessoaDTO.getCep());

        Pessoa pessoa = new Pessoa();

        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCep(pessoaDTO.getCep());
        pessoa.setScore(pessoaDTO.getScore());
        pessoa.setIdade(pessoaDTO.getIdade());
        pessoa.setTelefone(pessoaDTO.getTelefone());
        pessoa.setLogradouro(endereco.getLogradouro());
        pessoa.setEstado(endereco.getUf());
        pessoa.setCidade(endereco.getLocalidade());
        pessoa.setBairro(endereco.getBairro());

        pessoaRepository.save(pessoa);
    }

    public List<PessoaResponse> listarPessoas(String nome, String cep, Integer idade){
        List<PessoaDTO> pessoasDTO;

        if (nome != null) {
           pessoasDTO = modelMapper.entityListToDtoList(pessoaRepository.findByNomeContainingIgnoreCase(nome));
           return modelMapper.dtoListToResponseList(pessoasDTO);
        } else if (idade != null) {
             pessoasDTO = modelMapper.entityListToDtoList(pessoaRepository.findByCep(cep));
             return modelMapper.dtoListToResponseList(pessoasDTO);
        } else if (cep != null) {
             pessoasDTO = modelMapper.entityListToDtoList(pessoaRepository.findByIdade(idade));
             return modelMapper.dtoListToResponseList(pessoasDTO);
        } else {
             return null;
    }

    }

}
