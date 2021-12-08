package br.com.guinodo.votos.entity;

import br.com.guinodo.votos.domain.SessaoVotacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "SESSAO_VOTACAO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessaoVotacaoEntity {

    public SessaoVotacaoEntity(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PAUTA")
    private PautaEntity pauta;

    @Column( name = "DATA_INICIO" )
    private LocalDateTime dataInicio;

    @Column( name = "DATA_FIM" )
    private LocalDateTime dataFim;

    public static SessaoVotacaoEntity from(SessaoVotacao sessao) {
        return new SessaoVotacaoEntity(
                sessao.getId(),
                PautaEntity.from(sessao.getPauta()),
                sessao.getDataInicio(),
                sessao.getDataFim()
        );
    }

    public SessaoVotacao fromThis() {
        return new SessaoVotacao(
                id,
                pauta.fromThis(),
                dataInicio,
                dataFim

        );
    }

}
