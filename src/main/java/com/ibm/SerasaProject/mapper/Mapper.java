package com.ibm.SerasaProject.mapper;

import com.ibm.SerasaProject.dto.PessoaDTO;
import com.ibm.SerasaProject.model.pessoa.Pessoa;
import com.ibm.SerasaProject.model.pessoa.PessoaRequest;
import com.ibm.SerasaProject.model.pessoa.PessoaResponse;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Mapper {

    public PessoaDTO RequestToDto(PessoaRequest pessoaRequest) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pessoaRequest, PessoaDTO.class);
    }

    public Pessoa DtoToEntity(PessoaDTO pessoaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pessoaDTO, Pessoa.class);
    }

    public PessoaDTO EntityToDto(Pessoa pessoa) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pessoa, PessoaDTO.class);
    }

    public PessoaResponse DtoToResponse(PessoaDTO pessoaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pessoaDTO, PessoaResponse.class);
    }


}
