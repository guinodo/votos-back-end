package br.com.guinodo.votos.usecase;

import br.com.guinodo.votos.domain.Associado;
import br.com.guinodo.votos.domain.CPFResponse;
import br.com.guinodo.votos.domain.Pauta;
import br.com.guinodo.votos.domain.Voto;
import br.com.guinodo.votos.exception.BusinessException;
import br.com.guinodo.votos.repository.AssociadoRepository;
import br.com.guinodo.votos.repository.CpfRepository;
import br.com.guinodo.votos.repository.PautaRepository;
import br.com.guinodo.votos.repository.VotoRepository;
import br.com.guinodo.votos.service.CpfService;

import java.time.LocalDateTime;

public class VotarUseCase {

    private final VotoRepository votoRepository;
    private final PautaRepository pautaRepository;
    private final AssociadoRepository associadoRepository;
    private final CpfRepository cpfRepository;
    private final CpfService cpfService;

    public VotarUseCase(
        VotoRepository votoRepository,
        CpfRepository cpfRepository,
        PautaRepository pautaRepository,
        AssociadoRepository associadoRepository,
        CpfService cpfService){
        this.votoRepository = votoRepository;
        this.cpfRepository = cpfRepository;
        this.pautaRepository = pautaRepository;
        this.associadoRepository = associadoRepository;
        this.cpfService = cpfService;
    }

    public Voto votar(Voto voto) {


        Associado associado = associadoRepository.findById(voto.getAssociado().getId());
        Pauta pauta = pautaRepository.findById(voto.getPauta().getId());

        validarVoto(voto, pauta);

        CPFResponse cpfResponse = cpfRepository.find(voto.getAssociado().getCpf());

        if(cpfResponse.getStatus().equals("ABLE_TO_VOTE")){
            voto.setAssociado(associado);
            return votoRepository.save(voto);
        } else {
            throw new BusinessException(String.format("Usuario ja votou na pauta: %s", pauta.getNome()));
        }

    }

    private void validarVoto(Voto voto, Pauta pauta){

        cpfService.validarCpf(voto.getAssociado().getCpf());

        LocalDateTime now = LocalDateTime.now();
        if(!(now.isAfter(pauta.getDataInicio()) && now.isBefore(pauta.getDataFim()))){
            throw new BusinessException(String.format("Periodo de votacao encerrado para a pauta: %s", pauta.getNome()));
        }

    }

}
