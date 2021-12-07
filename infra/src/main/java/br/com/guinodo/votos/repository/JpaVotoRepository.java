package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.entity.VotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaVotoRepository extends JpaRepository<VotoEntity, Long> {}
