package br.com.guinodo.votos.usecase;

import br.com.guinodo.votos.domain.Pauta;
import br.com.guinodo.votos.repository.PautaRepository;

public class CadastroPautaUseCase {

    private final PautaRepository pautaRepository;

    public CadastroPautaUseCase(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    public void cadastroPauta(Pauta pauta) {
        this.pautaRepository.save(pauta);
    }

}
