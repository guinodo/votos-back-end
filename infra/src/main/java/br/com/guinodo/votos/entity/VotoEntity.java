package br.com.guinodo.votos.entity;

import br.com.guinodo.votos.domain.TipoVoto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "VOTO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VotoEntity implements Serializable {

    private static final long serialVersionUID = -4575451608224432567L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TIPO_VOTO")
    @Enumerated(EnumType.STRING)
    private TipoVoto tipoVoto;

}
