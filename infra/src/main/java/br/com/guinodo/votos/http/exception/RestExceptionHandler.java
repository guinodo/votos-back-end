package br.com.guinodo.votos.http.exception;

import br.com.guinodo.votos.exception.BusinessException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorMessage> businessException(BusinessException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage()
        );
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

}
