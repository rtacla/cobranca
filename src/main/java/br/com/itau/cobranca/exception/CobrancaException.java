package br.com.itau.cobranca.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CobrancaException extends RuntimeException {
	
	private String mensagem;
	
	public CobrancaException(String mensagem) {
		this.mensagem = mensagem;
	}

}
