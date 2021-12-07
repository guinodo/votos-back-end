package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.domain.CPFResponse;

public interface CpfRepository {
    CPFResponse find(String cpf);
}
