package br.com.itau.cobranca.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PENDENCIA_FINANCEIRA")
public class PendenciaFinanceira {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PENDENCIA_FINANCEIRA", unique = true, nullable = false)
	private Long idPendenciaFinanceira;
	
	private String cpf;
	
	private String documento;
	
	private BigDecimal valorOriginal;
	
	@Column(name = "DT_PENDENCIA")
	private LocalDate dataPendencia;
	
	@Column(name = "CNPJCPF_ORIGEM_PENDENCIA")
	private String cnpjCpfOrigemPendencia;
	
	private Long codigoCliente;
	
	@Column(name = "DT_CADASTRO")
	private LocalDateTime dataCadastro;
	
	

}
