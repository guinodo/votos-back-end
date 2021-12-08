package br.com.guinodo.votos.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(final String details) {
        super(details);
    }

}
