package br.com.guinodo.votos.entity;

import br.com.guinodo.votos.domain.Associado;
import br.com.guinodo.votos.domain.Pauta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ASSOCIADO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssociadoEntity {

    public AssociadoEntity(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF")
    private String cpf;

    public static AssociadoEntity from(Associado associado) {
        return new AssociadoEntity(
                associado.getId(),
                associado.getNome(),
                associado.getCpf()
        );
    }

    public Associado fromThis() {
        return new Associado(
                id,
                nome,
                cpf
        );
    }

}
