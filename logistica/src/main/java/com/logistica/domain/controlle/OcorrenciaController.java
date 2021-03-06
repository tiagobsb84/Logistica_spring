package com.logistica.domain.controlle;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.logistica.domain.assembler.OcorrenciaAssembler;
import com.logistica.domain.model.Entrega;
import com.logistica.domain.model.Ocorrencia;
import com.logistica.domain.service.BuscarEntregaService;
import com.logistica.domain.service.ResgistreOcorreciaService;
import com.logistica.model.OcorrenciaInput;
import com.logistica.model.OcorrenciaModel;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

	private ResgistreOcorreciaService registroOcorrenciaService;
	private OcorrenciaAssembler ocorrenciaAssembler;
	private BuscarEntregaService buscarEntregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registra(@PathVariable Long entregaId,
			@Valid @RequestBody OcorrenciaInput ocorrencialInput) {
		
		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId, 
				ocorrencialInput.getDescricao());
				
	
		return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
	}
	
	@GetMapping
	public List<OcorrenciaModel> listar(@PathVariable Long entregaId){
		Entrega entrega = buscarEntregaService.buscar(entregaId);
	
		return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
	}
}
