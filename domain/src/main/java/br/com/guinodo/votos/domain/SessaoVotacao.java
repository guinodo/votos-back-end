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
public class SessaoVotacao {
    private Long id;
    private Pauta pauta;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
}
