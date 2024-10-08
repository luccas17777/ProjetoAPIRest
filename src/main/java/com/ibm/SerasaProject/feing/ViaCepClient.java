package com.ibm.SerasaProject.feing;

import com.ibm.SerasaProject.dto.EnderecoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "viacep.com.br/ws/")
public interface ViaCepClient {
    @GetMapping("{cep}/json/")
    EnderecoDTO buscarEnderecoPorCep(@PathVariable("cep") String cep);
}
