package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.domain.Pauta;
import br.com.guinodo.votos.entity.PautaEntity;
import org.modelmapper.ModelMapper;

public class PautaRepositoryImpl implements PautaRepository {

    private final JpaPautaRepository repository;

    public PautaRepositoryImpl(JpaPautaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pauta save(Pauta pauta) {
        return repository.save(PautaEntity.from(pauta)).fromThis();
    }

}
