package br.com.guinodo.votos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "PAUTA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PautaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column( name = "DATA_INICIO" )
    private LocalDateTime dataInicio;

    @Column( name = "DATA_FIM" )
    private LocalDateTime DataFim;

}
