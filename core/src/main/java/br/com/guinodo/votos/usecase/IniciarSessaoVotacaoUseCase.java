package br.com.guinodo.votos.usecase;

import br.com.guinodo.votos.domain.IniciarSessaoVotacao;
import br.com.guinodo.votos.domain.Pauta;
import br.com.guinodo.votos.domain.SessaoVotacao;
import br.com.guinodo.votos.repository.PautaRepository;
import br.com.guinodo.votos.repository.SessaoVotacaoRepository;

import java.time.LocalDateTime;

public class IniciarSessaoVotacaoUseCase {

    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PautaRepository pautaRepository;

    public IniciarSessaoVotacaoUseCase(
            SessaoVotacaoRepository sessaoVotacaoRepository, PautaRepository pautaRepository
    ) {
        this.sessaoVotacaoRepository = sessaoVotacaoRepository;
        this.pautaRepository = pautaRepository;
    }

    public SessaoVotacao iniciar(IniciarSessaoVotacao iniciarSessao) {

        Pauta pauta = pautaRepository.findById(iniciarSessao.getIdPauta());
        SessaoVotacao sessaoVotacao = new SessaoVotacao();

        LocalDateTime now = LocalDateTime.now();
        sessaoVotacao.setPauta(pauta);
        sessaoVotacao.setDataInicio(now);
        sessaoVotacao.setDataFim(now.plusSeconds(iniciarSessao.getPeriodo()));

        return sessaoVotacaoRepository.save(sessaoVotacao);
    }

}
