package com.logistica.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.logistica.domain.model.Entrega;
import com.logistica.domain.model.Ocorrencia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ResgistreOcorreciaService {

	private BuscarEntregaService buscarEntregaService;
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega = buscarEntregaService.buscar(entregaId);
		
		return entrega.adicionarOcorrencia(descricao);
	}
}
