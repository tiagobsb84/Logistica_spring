package com.logistica.domain.service;

import org.springframework.stereotype.Service;

import com.logistica.domain.model.Entrega;
import com.logistica.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

	private EntregaRepository entregaRepository;
	private BuscarEntregaService buscarEntregaService;
	
	public void finalizar(Long entregaId) {
		Entrega entrega = buscarEntregaService.buscar(entregaId);

		entrega.finalizar();
		
		entregaRepository.save(entrega);
	}
}
