package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.domain.Voto;
import br.com.guinodo.votos.entity.VotoEntity;
import org.springframework.stereotype.Repository;

@Repository
public class VotoRepositoryImpl implements VotoRepository {

    private JpaVotoRepository repository;

    public VotoRepositoryImpl(JpaVotoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Voto save(Voto voto) {
        return repository.save(VotoEntity.from(voto)).fromThis();
    }
}
