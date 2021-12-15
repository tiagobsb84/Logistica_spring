package com.logistica.domain.service;

import org.springframework.stereotype.Service;

import com.logistica.domain.exception.EntidadeNaoEncontradaException;
import com.logistica.domain.model.Entrega;
import com.logistica.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscarEntregaService {

	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entradaId) {
		return entregaRepository.findById(entradaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada."));
	}
}
