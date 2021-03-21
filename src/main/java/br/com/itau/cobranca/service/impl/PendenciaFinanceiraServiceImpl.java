package br.com.itau.cobranca.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.itau.cobranca.dto.FiltroPendenciaFinanceiraAgrupadoDTO;
import br.com.itau.cobranca.dto.FiltroPendenciaFinanceiraDTO;
import br.com.itau.cobranca.dto.PendenciaFinanceiraDTO;
import br.com.itau.cobranca.entity.PendenciaFinanceira;
import br.com.itau.cobranca.exception.CobrancaException;
import br.com.itau.cobranca.repository.PendenciaFinanceiraRepository;
import br.com.itau.cobranca.service.PendenciaFinanceiraService;
import br.com.itau.cobranca.util.MapeadorUtil;

@Service
public class PendenciaFinanceiraServiceImpl implements PendenciaFinanceiraService {

	@Autowired
	private PendenciaFinanceiraRepository pendenciaFinanceiraRepository;

	@Autowired
	private MapeadorUtil mapeadorUtil;


	@Override
	public PendenciaFinanceiraDTO buscaPorCPFDocto(FiltroPendenciaFinanceiraDTO filtro) {
		try {
			PendenciaFinanceira pendencia = pendenciaFinanceiraRepository.buscaPendenciaPorCPFDocto(filtro.getCpf(), filtro.getDocumento());
			if(pendencia==null) {
				throw new CobrancaException("Não foi encontrado registro para este CPF e Documento");
			}
			PendenciaFinanceiraDTO pendenciaDTO = mapeadorUtil.convertoPendenciaToDto(pendencia);
			return pendenciaDTO;
		} catch (CobrancaException ce) {
			throw ce;
		} catch (Exception ex) {
			throw new CobrancaException("Erro na consulta de Pendencia Financeira por CPF e Documento");
		}
	}

	@Override
	public List<PendenciaFinanceiraDTO> buscaPorCPF(FiltroPendenciaFinanceiraAgrupadoDTO filtro) {
		try {
			List<PendenciaFinanceira> pendencias = pendenciaFinanceiraRepository.buscaPendenciaPorCPF(filtro.getCpf());
			if(pendencias==null || pendencias.size()==0) {
				throw new CobrancaException("Não foram encontrados registros para este CPF");
			}
			List<PendenciaFinanceiraDTO> pendenciasDTO = pendencias.stream().map(pend -> mapeadorUtil.convertoPendenciaToDto(pend)).collect(Collectors.toList());
			return pendenciasDTO;
		} catch (CobrancaException ce) {
			throw ce;
		} catch (Exception ex) {
			throw new CobrancaException("Erro na consulta de Pendencia Financeira por CPF");
		}
	}

}
