package com.logistica.domain.controlle;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logistica.domain.model.Cliente;
import com.logistica.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ControllerCliente {
	
	private ClienteRepository clienterepository;
	
	@GetMapping("/clientes")
	public List<Cliente> lista() {
		return clienterepository.findAll(); 
	}
}