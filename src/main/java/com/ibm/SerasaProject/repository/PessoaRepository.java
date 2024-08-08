package com.ibm.SerasaProject.repository;

import com.ibm.SerasaProject.model.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByNomeContainingIgnoreCase(String nome);
    List<Pessoa> findByIdade(Integer idade);
    List<Pessoa> findByCep(String cep);
}
