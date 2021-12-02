package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.domain.Voto;

public class VotoRepositoryImpl implements VotoRepository {

    private final GenericRepository repository;

    public VotoRepositoryImpl(GenericRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Voto voto) {
        repository.save(voto);
    }
}
