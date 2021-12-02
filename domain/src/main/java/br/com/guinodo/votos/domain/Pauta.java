package br.com.guinodo.votos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pauta {

    private Long id;
    private String nome;
    private LocalDateTime dataInicio;
    private LocalDateTime DataFim;

}
