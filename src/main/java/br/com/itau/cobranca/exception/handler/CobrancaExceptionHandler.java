package br.com.itau.cobranca.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.itau.cobranca.exception.CobrancaException;

@RestControllerAdvice
public class CobrancaExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler( CobrancaException.class )
	public ResponseEntity< String > handle( CobrancaException e ) throws Exception {
		return new ResponseEntity<>( "{ \"mensagem\": \"" + e.getMensagem() + "\"}", HttpStatus.BAD_REQUEST );
	}
}
