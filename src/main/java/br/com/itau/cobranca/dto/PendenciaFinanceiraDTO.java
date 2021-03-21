package br.com.itau.cobranca.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PendenciaFinanceiraDTO {
		private String cpf;
		
		private String documento;
		
		private BigDecimal valorOriginal;
		
		private LocalDate dataPendencia;
		
		private String cnpjCpfOrigemPendencia;
		
		private Long codigoCliente;
		

}
