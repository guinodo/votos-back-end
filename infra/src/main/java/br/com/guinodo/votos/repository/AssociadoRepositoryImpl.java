package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.domain.Associado;
import br.com.guinodo.votos.exception.BusinessException;

public class AssociadoRepositoryImpl implements AssociadoRepository {

    private final JpaAssociadoRepository repository;

    public AssociadoRepositoryImpl(JpaAssociadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Associado findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BusinessException("Associado nao encontrado")).fromThis();
    }

}
