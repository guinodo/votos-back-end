package br.com.guinodo.votos.usecase;

import br.com.guinodo.votos.domain.Pauta;
import br.com.guinodo.votos.exception.BusinessException;
import br.com.guinodo.votos.repository.PautaRepository;

import java.time.LocalDateTime;

public class CadastroPautaUseCase {

    private final PautaRepository pautaRepository;

    public CadastroPautaUseCase(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    public Pauta cadastroPauta(Pauta pauta) {
        validarPauta(pauta);
        return pautaRepository.save(pauta);
    }

    private void validarPauta(Pauta pauta) {

        LocalDateTime now = LocalDateTime.now();

        if(pauta.getDataInicio().isBefore(now)){
            throw new BusinessException("Inicio de votacao invalido");
        }

        if(pauta.getDataFim().isBefore(pauta.getDataInicio())){
            throw new BusinessException("Data fim menor que data inicio");
        }

    }

}
