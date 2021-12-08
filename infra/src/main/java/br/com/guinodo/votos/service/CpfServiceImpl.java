package br.com.guinodo.votos.service;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.guinodo.votos.exception.BusinessException;

public class CpfServiceImpl implements CpfService {

    private final CPFValidator cpfValidator;

    public CpfServiceImpl(CPFValidator cpfValidator) {
        this.cpfValidator = cpfValidator;
    }

    @Override
    public void validarCpf(String cpf) {
        try {
            cpfValidator.assertValid(cpf);
        } catch (InvalidStateException ex) {
            throw new BusinessException(String.format("CPF invalido : %s", cpf));
        }
    }

}
