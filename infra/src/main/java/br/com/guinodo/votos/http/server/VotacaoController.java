package br.com.guinodo.votos.http.server;

import br.com.guinodo.votos.domain.Voto;
import br.com.guinodo.votos.usecase.VotarUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/votacao")
public class VotacaoController {

    @Autowired
    private VotarUseCase votarUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<?> votar(@RequestBody final Voto voto) {
        return ResponseEntity.ok(votarUseCase.votar(voto));
    }

}
