package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.domain.Voto;
import br.com.guinodo.votos.entity.AssociadoEntity;
import br.com.guinodo.votos.entity.SessaoVotacaoEntity;
import br.com.guinodo.votos.entity.VotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaVotoRepository extends JpaRepository<VotoEntity, Long> {
    Optional<VotoEntity> findBySessaoAndAssociado(SessaoVotacaoEntity sessaoVotacaoEntity, AssociadoEntity associadoEntity);
}
