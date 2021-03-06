package br.com.itau.cobranca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.cobranca.dto.FiltroPendenciaFinanceiraAgrupadoDTO;
import br.com.itau.cobranca.dto.FiltroPendenciaFinanceiraDTO;
import br.com.itau.cobranca.dto.PendenciaFinanceiraDTO;
import br.com.itau.cobranca.service.PendenciaFinanceiraService;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	
	@Autowired
	private PendenciaFinanceiraService pendenciaFinanceiraService;
	
	
    @ApiOperation( "Recupera PendĂȘncia por CPF e Documento" )
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PendenciaFinanceiraDTO> getPendenciaCPFDocto(@RequestBody FiltroPendenciaFinanceiraDTO filtro, @ApiIgnore @RequestHeader(value = "Authorization") String jwt) {
    	PendenciaFinanceiraDTO pendencia = pendenciaFinanceiraService.buscaPorCPFDocto(filtro);
    	return new ResponseEntity<PendenciaFinanceiraDTO>(pendencia, HttpStatus.OK);
    }
    
    @ApiOperation( "Recupera PendĂȘncias por CPF" )
    @PostMapping(path="/agrupado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PendenciaFinanceiraDTO>> getPendenciasCPF(@RequestBody FiltroPendenciaFinanceiraAgrupadoDTO filtro, @ApiIgnore @RequestHeader(value = "Authorization") String jwt) {
    	List<PendenciaFinanceiraDTO> pendencias = pendenciaFinanceiraService.buscaPorCPF(filtro);
    	return new ResponseEntity<List<PendenciaFinanceiraDTO>>(pendencias, HttpStatus.OK);
    }
	
}
