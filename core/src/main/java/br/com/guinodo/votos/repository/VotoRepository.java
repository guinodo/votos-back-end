package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.domain.Voto;

public interface VotoRepository {
    Voto save(Voto voto);
}
