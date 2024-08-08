package com.ibm.SerasaProject.mapper;

import com.ibm.SerasaProject.dto.PessoaDTO;
import com.ibm.SerasaProject.model.pessoa.Pessoa;
import com.ibm.SerasaProject.model.pessoa.PessoaRequest;
import com.ibm.SerasaProject.model.pessoa.PessoaResponse;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;


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

    public List<PessoaDTO> entityListToDtoList(List<Pessoa> pessoas) {
        ModelMapper modelMapper = new ModelMapper();
        return pessoas.stream()
                .map(pessoa -> modelMapper.map(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaResponse> dtoListToResponseList(List<PessoaDTO> pessoasDto) {
        ModelMapper modelMapper = new ModelMapper();
        return pessoasDto.stream()
                .map(pessoa -> modelMapper.map(pessoa, PessoaResponse.class))
                .collect(Collectors.toList());
    }


}
