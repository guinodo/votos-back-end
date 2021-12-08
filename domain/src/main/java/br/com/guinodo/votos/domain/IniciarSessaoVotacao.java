package br.com.guinodo.votos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IniciarSessaoVotacao {
    private Long idPauta;
    private Long periodo;
}
