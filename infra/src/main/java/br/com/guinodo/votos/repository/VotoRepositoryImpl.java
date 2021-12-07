package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.domain.TipoVoto;
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
    public void save(Voto voto) {
//        repository.save(new VotoEntity());
    }
}
