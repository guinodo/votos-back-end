package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.domain.Pauta;
import br.com.guinodo.votos.entity.PautaEntity;

public class PautaRepositoryImpl implements PautaRepository {

    private final JpaPautaRepository repository;

    public PautaRepositoryImpl(JpaPautaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Pauta pauta) {
        repository.save(new PautaEntity());
    }

}
