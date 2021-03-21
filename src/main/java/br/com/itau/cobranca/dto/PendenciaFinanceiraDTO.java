package br.com.itau.cobranca.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

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
		
	    @JsonFormat( pattern = "yyyy-MM-dd")
	    @JsonDeserialize( using = LocalDateDeserializer.class )
	    @JsonSerialize( using = LocalDateSerializer.class )
		private LocalDate dataPendencia;
		
		private String cnpjCpfOrigemPendencia;
		
		private Long codigoCliente;
		

}
