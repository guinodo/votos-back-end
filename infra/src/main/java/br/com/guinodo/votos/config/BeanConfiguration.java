package br.com.guinodo.votos.config;

import br.com.guinodo.votos.http.client.CPFClient;
import br.com.guinodo.votos.repository.CpfRepository;
import br.com.guinodo.votos.repository.JpaPautaRepository;
import br.com.guinodo.votos.repository.JpaVotoRepository;
import br.com.guinodo.votos.repository.PautaRepository;
import br.com.guinodo.votos.repository.PautaRepositoryImpl;
import br.com.guinodo.votos.repository.VotoRepository;
import br.com.guinodo.votos.repository.VotoRepositoryImpl;
import br.com.guinodo.votos.usecase.CadastroPautaUseCase;
import br.com.guinodo.votos.usecase.VotarUseCase;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public VotoRepository votoRepository(JpaVotoRepository repository) {
        return new VotoRepositoryImpl(repository);
    }

    @Bean
    public CpfRepository cpfRepository() {
        return new CPFClient();
    }

    @Bean
    public PautaRepository pautaRepository(JpaPautaRepository repository) {
        return new PautaRepositoryImpl(repository);
    }

    @Bean
    public VotarUseCase votarUseCase(
        VotoRepository votoRepository,
        CpfRepository cpfRepository
    ) {
        return new VotarUseCase(votoRepository, cpfRepository);
    }

    @Bean
    public CadastroPautaUseCase cadastroPautaUseCase (PautaRepository pautaRepository) {
        return new CadastroPautaUseCase(pautaRepository);
    }

}
