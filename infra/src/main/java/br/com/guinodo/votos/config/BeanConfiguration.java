package br.com.guinodo.votos.config;

import br.com.guinodo.votos.http.client.CPFClient;
import br.com.guinodo.votos.repository.CpfRepository;
import br.com.guinodo.votos.repository.JpaVotoRepository;
import br.com.guinodo.votos.repository.VotoRepository;
import br.com.guinodo.votos.repository.VotoRepositoryImpl;
import br.com.guinodo.votos.usecase.VotarUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public VotoRepository votoRepository(JpaVotoRepository repository) {
        return new VotoRepositoryImpl(repository);
    }

    @Bean
    public CpfRepository cpfRepository() {
        return new CPFClient();
    }

    @Bean
    public VotarUseCase votarUseCase(
        VotoRepository votoRepository,
        CpfRepository cpfRepository
    ) {
        return new VotarUseCase(votoRepository, cpfRepository);
    }

}
