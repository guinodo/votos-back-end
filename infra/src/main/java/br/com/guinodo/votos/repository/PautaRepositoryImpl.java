package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.domain.Pauta;
import br.com.guinodo.votos.entity.PautaEntity;
import br.com.guinodo.votos.exception.BusinessException;
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

    @Override
    public Pauta findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BusinessException("Pauta nao encontrada")).fromThis();
    }


}
