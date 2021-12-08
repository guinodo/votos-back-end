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
public class Voto {

    private Long id;
    private Pauta pauta;
    private Associado associado;
    private TipoVoto tipoVoto;

}
