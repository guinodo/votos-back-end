package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.entity.PautaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPautaRepository extends JpaRepository<PautaEntity, Long> { }
