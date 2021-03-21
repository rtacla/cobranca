package br.com.itau.cobranca.service;

import java.util.List;

import br.com.itau.cobranca.dto.FiltroPendenciaFinanceiraAgrupadoDTO;
import br.com.itau.cobranca.dto.FiltroPendenciaFinanceiraDTO;
import br.com.itau.cobranca.dto.PendenciaFinanceiraDTO;

public interface PendenciaFinanceiraService {

	PendenciaFinanceiraDTO buscaPorCPFDocto(FiltroPendenciaFinanceiraDTO filtro);

	List<PendenciaFinanceiraDTO> buscaPorCPF(FiltroPendenciaFinanceiraAgrupadoDTO filtro);

}
