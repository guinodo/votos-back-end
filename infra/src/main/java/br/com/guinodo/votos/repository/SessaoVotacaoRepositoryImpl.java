package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.domain.SessaoVotacao;
import br.com.guinodo.votos.entity.SessaoVotacaoEntity;
import br.com.guinodo.votos.exception.BusinessException;
import org.springframework.stereotype.Repository;

@Repository
public class SessaoVotacaoRepositoryImpl implements SessaoVotacaoRepository {

    private final JpaSessaoVotacaoRepository repository;

    public SessaoVotacaoRepositoryImpl(JpaSessaoVotacaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public SessaoVotacao save(SessaoVotacao sessaoVotacao) {
        return repository.save(SessaoVotacaoEntity.from(sessaoVotacao)).fromThis();
    }

    @Override
    public SessaoVotacao findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BusinessException("Sesssao nao encontrada")).fromThis();
    }
}
