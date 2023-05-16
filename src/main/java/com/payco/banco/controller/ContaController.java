package com.payco.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payco.banco.model.Conta;
import com.payco.banco.repository.ContaRepository;

@RestController
@RequestMapping("/contas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContaController {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@GetMapping
	public ResponseEntity <List<Conta>> getAll(){
		return ResponseEntity.ok(contaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Conta> getById(@PathVariable Long id){
		return contaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
		
	@PostMapping("/cadastroUsuario")
	public ResponseEntity<Conta> criarConta(@RequestBody Conta conta){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(contaRepository.save(conta));
		
	}

}
