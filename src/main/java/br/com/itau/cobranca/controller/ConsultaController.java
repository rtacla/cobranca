package br.com.itau.cobranca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.cobranca.dto.FiltroPendenciaFinanceiraDTO;
import br.com.itau.cobranca.dto.PendenciaFinanceiraDTO;
import br.com.itau.cobranca.service.PendenciaFinanceiraService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	
	@Autowired
	private PendenciaFinanceiraService pendenciaFinanceiraService;
	
	
    @ApiOperation( "Recupera Pendência por CPF e Documento" )
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PendenciaFinanceiraDTO> getPendenciaCPFDocto(@RequestBody FiltroPendenciaFinanceiraDTO filtro) {
    	PendenciaFinanceiraDTO pendencia = pendenciaFinanceiraService.buscaPorCPFDocto(filtro);
    	return new ResponseEntity<PendenciaFinanceiraDTO>(pendencia, HttpStatus.OK);
    }
    
    @ApiOperation( "Recupera Pendências por CPF" )
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PendenciaFinanceiraDTO>> getPendenciasCPF(@RequestBody FiltroPendenciaFinanceiraDTO filtro) {
    	List<PendenciaFinanceiraDTO> pendencias = pendenciaFinanceiraService.buscaPorCPF(filtro);
    	return new ResponseEntity<List<PendenciaFinanceiraDTO>>(pendencias, HttpStatus.OK);
    }
	
}
