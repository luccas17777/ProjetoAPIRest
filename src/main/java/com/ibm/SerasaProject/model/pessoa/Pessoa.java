package com.ibm.SerasaProject.model.pessoa;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Pessoa {
    private String nome;
    private Integer idade;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String telefone;
    private Integer score;
}
