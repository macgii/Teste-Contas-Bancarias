package com.payco.banco.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payco.banco.model.Conta;
import com.payco.banco.repository.ContaRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/contas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Contas", description = "Operações relacionadas aos contas")
public class ContaController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContaController.class);
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Operation(summary = "Obter contas", description = "Operação que lista todas as contas bancárias.")
	@ApiResponse(responseCode = "200", description = "Lista de contas encontrada.")
	@GetMapping
	public ResponseEntity <List<Conta>> getAll(){
		logger.info("ContaController: iniciando método getAll()");
		return ResponseEntity.ok(contaRepository.findAll());
	}
	
	@Operation(summary = "Obter conta por ID", description = "Operação que busca conta bancária por ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Conta encontrada com sucesso."),
			@ApiResponse(responseCode = "404", description = "Conta não encontrada")	
	})
	@GetMapping("/{id}")
	public ResponseEntity<Conta> getById(@Parameter(in = ParameterIn.PATH, description = "ID da conta") @PathVariable Long id){
		logger.info("ContaController: Iniciando método getById() - Id = {}", id);
		return contaRepository.findById(id)	
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@Operation(summary = "Criar conta", description = "Operação que cria uma conta bancária.")
	@ApiResponse(responseCode = "201", description = "Conta criada com sucesso.")
	@PostMapping
	public ResponseEntity<Conta> criarConta(@Parameter(in = ParameterIn.DEFAULT, description = "Dados da conta a ser criada") @RequestBody Conta conta){
		logger.info("ContaController: Iniciando método criarConta() - Conta = {}", conta.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(contaRepository.save(conta));
	}
	
	@Operation(summary = "Atualizar conta por ID", description = "Operação que atualiza dados de uma conta bancária por ID.")
	@ApiResponse(responseCode = "201", description = "Conta atualizada com sucesso.")
	@PutMapping("/{id}")
	public ResponseEntity<Conta> atualizarConta(@Parameter(in = ParameterIn.DEFAULT, description = "Dados da conta a ser criada") @RequestBody Conta conta){
		logger.info("ContaController: Iniciando método atualizarConta() - Conta = {}", conta.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(contaRepository.save(conta));
	}
	
	@Operation(summary = "Deletar conta por ID", description = "Operação que deleta uma conta bancária por ID.")
	@ApiResponse(responseCode = "200", description = "Conta deletada com sucesso.")
	@DeleteMapping("/{id}")
	public void deletar(@Parameter(in = ParameterIn.PATH, description = "ID da conta") @PathVariable Long id) {
		logger.info("ContaController: Iniciando método deletar() - Id = {}", id);
		contaRepository.deleteById(id);
		logger.info("Conta deletada com sucesso.");
		
	}
	
}
