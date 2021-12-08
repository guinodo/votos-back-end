package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.domain.Associado;

public interface AssociadoRepository {
    Associado findById(Long id);
}
