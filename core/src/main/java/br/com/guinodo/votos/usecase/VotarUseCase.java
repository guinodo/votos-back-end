package br.com.guinodo.votos.usecase;

import br.com.guinodo.votos.domain.Voto;
import br.com.guinodo.votos.repository.VotoRepository;

public class VotarUseCase {

    private final VotoRepository votoRepository;

    public VotarUseCase(VotoRepository votoRepository){
        this.votoRepository = votoRepository;
    }

    public Voto votar(Voto voto) {
        System.out.println("Votar");
        return voto;
    }

}
