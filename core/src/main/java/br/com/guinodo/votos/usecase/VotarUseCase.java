package br.com.guinodo.votos.usecase;

import br.com.guinodo.votos.domain.CPFResponse;
import br.com.guinodo.votos.domain.Voto;
import br.com.guinodo.votos.repository.CpfRepository;
import br.com.guinodo.votos.repository.VotoRepository;

public class VotarUseCase {

    private final VotoRepository votoRepository;
    private final CpfRepository cpfRepository;

    public VotarUseCase(
        VotoRepository votoRepository,
        CpfRepository cpfRepository
    ){
        this.votoRepository = votoRepository;
        this.cpfRepository = cpfRepository;
    }

    public Voto votar(Voto voto) {

        CPFResponse cpfResponse = cpfRepository.find(voto.getAssociado().getCpf());

        if(cpfResponse.getStatus().equals("ABLE_TO_VOTE")){
            votoRepository.save(voto);
        } else {
            throw new RuntimeException("Associado ja votou");
        }

        return voto;
    }

}
