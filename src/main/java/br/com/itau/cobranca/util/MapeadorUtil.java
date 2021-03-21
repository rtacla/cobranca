package br.com.itau.cobranca.util;

import org.springframework.stereotype.Component;

import br.com.itau.cobranca.dto.PendenciaFinanceiraDTO;
import br.com.itau.cobranca.entity.PendenciaFinanceira;

@Component
public class MapeadorUtil {

	public PendenciaFinanceiraDTO convertoPendenciaToDto(PendenciaFinanceira pend) {
		return PendenciaFinanceiraDTO.builder()
				.cpf(pend.getCpf())
				.documento(pend.getDocumento())
				.valorOriginal(pend.getValorOriginal())
				.dataPendencia(pend.getDataPendencia())
				.cnpjCpfOrigemPendencia(pend.getCnpjCpfOrigemPendencia())
				.codigoCliente(pend.getCodigoCliente())
				.build();
	}
	
	

}
