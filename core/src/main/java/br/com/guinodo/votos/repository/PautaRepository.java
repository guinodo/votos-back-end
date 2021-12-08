package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.domain.Pauta;

public interface PautaRepository {
    Pauta save(Pauta pauta);
    Pauta findById(Long id);
}
