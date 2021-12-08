package br.com.guinodo.votos.usecase;

import br.com.guinodo.votos.domain.Associado;
import br.com.guinodo.votos.domain.CPFResponse;
import br.com.guinodo.votos.domain.SessaoVotacao;
import br.com.guinodo.votos.domain.Voto;
import br.com.guinodo.votos.exception.BusinessException;
import br.com.guinodo.votos.repository.AssociadoRepository;
import br.com.guinodo.votos.repository.CpfRepository;
import br.com.guinodo.votos.repository.SessaoVotacaoRepository;
import br.com.guinodo.votos.repository.VotoRepository;
import br.com.guinodo.votos.service.CpfService;

import java.time.LocalDateTime;

public class VotarUseCase {

    private final VotoRepository votoRepository;
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final AssociadoRepository associadoRepository;
    private final CpfRepository cpfRepository;
    private final CpfService cpfService;

    public VotarUseCase(
        VotoRepository votoRepository,
        CpfRepository cpfRepository,
        SessaoVotacaoRepository sessaoVotacaoRepository,
        AssociadoRepository associadoRepository,
        CpfService cpfService){
        this.votoRepository = votoRepository;
        this.cpfRepository = cpfRepository;
        this.sessaoVotacaoRepository = sessaoVotacaoRepository;
        this.associadoRepository = associadoRepository;
        this.cpfService = cpfService;
    }

    public Voto votar(Voto voto) {

        Associado associado = associadoRepository.findById(voto.getAssociado().getId());
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.findById(voto.getSessao().getId());

        validarVoto(voto, sessaoVotacao);

        CPFResponse cpfResponse = cpfRepository.find(voto.getAssociado().getCpf());

        if(cpfResponse.getStatus().equals("ABLE_TO_VOTE")){
            voto.setAssociado(associado);
            return votoRepository.save(voto);
        } else {
            throw new BusinessException("Usuario ja votou");
        }

    }

    private void validarVoto(Voto voto, SessaoVotacao sessaoVotacao){

        cpfService.validarCpf(voto.getAssociado().getCpf());

        LocalDateTime now = LocalDateTime.now();
        if(!(now.isAfter(sessaoVotacao.getDataInicio()) && now.isBefore(sessaoVotacao.getDataFim()))){
            throw new BusinessException("Periodo de votacao encerrado");
        }

    }

}
