package br.com.guinodo.votos.repository;

import br.com.guinodo.votos.entity.AssociadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAssociadoRepository extends JpaRepository<AssociadoEntity, Long> { }