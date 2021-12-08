package br.com.guinodo.votos.http.client;

import br.com.guinodo.votos.domain.CPFResponse;
import br.com.guinodo.votos.repository.CpfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CPFClient implements CpfRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.cpf.url}")
    private String API_CPF_URL;

    @Override
    public CPFResponse find(String cpf) {
        return restTemplate.getForObject(API_CPF_URL+"/"+cpf, CPFResponse.class);
    }
}
