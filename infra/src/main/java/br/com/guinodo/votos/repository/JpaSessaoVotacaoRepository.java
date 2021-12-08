package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.entity.SessaoVotacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSessaoVotacaoRepository extends JpaRepository<SessaoVotacaoEntity, Long> { }
