package br.com.guinodo.votos.http.server;

import br.com.guinodo.votos.domain.IniciarSessaoVotacao;
import br.com.guinodo.votos.domain.Pauta;
import br.com.guinodo.votos.usecase.CadastroPautaUseCase;
import br.com.guinodo.votos.usecase.IniciarSessaoVotacaoUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Controle de Pauta")
@RestController
@RequestMapping("/v1/pauta")
public class PautaController {

    @Autowired
    private CadastroPautaUseCase cadastroPautaUseCase;

    @Autowired
    private IniciarSessaoVotacaoUseCase iniciarSessaoVotacaoUseCase;

    @ApiOperation(value="Criar Pauta")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<?> save(@RequestBody final Pauta pauta) {
        return ResponseEntity.ok(cadastroPautaUseCase.cadastroPauta(pauta));
    }

    @ApiOperation(value="Abrir sessão de votacao em uma pauta")
    @PostMapping({"/abrir-sessao-votacao"})
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<?> abrirSessaoVotacao(@RequestBody final IniciarSessaoVotacao iniciarSessaoVotacao) {
        return ResponseEntity.ok(iniciarSessaoVotacaoUseCase.iniciar(iniciarSessaoVotacao));
    }

}
