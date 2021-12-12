package com.logistica.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistica.domain.model.Cliente;
import com.logistica.domain.model.Entrega;
import com.logistica.domain.model.StatusEntrega;
import com.logistica.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SolicitacaoeEntregaService {

	private EntregaRepository entregaRepository;
	
	private CatalogoClienteService catalogoClienteService;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		
		return entregaRepository.save(entrega);
	}
}
