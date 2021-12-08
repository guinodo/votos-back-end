package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.domain.SessaoVotacao;

public interface SessaoVotacaoRepository {
    SessaoVotacao save(SessaoVotacao sessaoVotacao);
    SessaoVotacao findById(Long id);
}
