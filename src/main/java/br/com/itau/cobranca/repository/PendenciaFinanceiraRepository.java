package br.com.itau.cobranca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.itau.cobranca.entity.PendenciaFinanceira;

public interface PendenciaFinanceiraRepository extends JpaRepository<PendenciaFinanceira, Long> {
	
	@Query("select pf from PendenciaFinanceira pf where pf.cpf = ?1")
	List<PendenciaFinanceira> buscaPendenciaPorCPF(String cpf);
	
	@Query("select pf from PendenciaFinanceira pf where pf.cpf = ?1 and pf.documento = ?2")
	PendenciaFinanceira buscaPendenciaPorCPFDocto(String cpf, String documento);


}
