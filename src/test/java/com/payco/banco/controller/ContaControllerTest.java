package com.payco.banco.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.payco.banco.model.Conta;
import com.payco.banco.repository.ContaRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("Teste da classe ContaControllerTest")
class ContaControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@BeforeEach
	void deletarBanco(){
		contaRepository.deleteAll();
	}

	@Test
	@DisplayName("Método que busca todas as contas - getAll()")
	void getAll() {
		ResponseEntity<List<Conta>> resposta = testRestTemplate.exchange("/contas", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Conta>>() {
				});
		assertEquals(HttpStatus.OK, resposta.getStatusCode(), "Status Code da lista de contas deve ser igual");
	}

	@Test
	@DisplayName("Método que busca conta por Id - getById()")
	void getById() {
		
		HttpEntity<Conta> requisicao = new HttpEntity<Conta>(new Conta(null, "Catarina", 12394508401L, 87667321, 2800));
		ResponseEntity<Conta> resposta = testRestTemplate.exchange("/contas", HttpMethod.POST, requisicao, Conta.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode(), "Status Code da conta criada deve ser igual");


		ResponseEntity<Conta> resposta1 = testRestTemplate.exchange("/contas/{id}", HttpMethod.GET, null, Conta.class,
				resposta.getBody().getId());

		assertEquals(HttpStatus.OK, resposta1.getStatusCode(), "Status Code da conta deve ser igual");
		assertEquals(resposta.getBody().getId(), resposta1.getBody().getId(), "Id da conta deve ser igual");
		assertEquals(resposta.getBody().getTitular(), resposta1.getBody().getTitular(), "Titular da conta deve ser igual");
		assertEquals(resposta.getBody().getCpf(), resposta1.getBody().getCpf(), "CPF da conta deve ser igual");
		assertEquals(resposta.getBody().getNumeroConta(), resposta1.getBody().getNumeroConta(), "Numero da conta da conta deve ser igual");
		assertEquals(resposta.getBody().getSaldo(), resposta1.getBody().getSaldo(), "Saldo da conta deve ser igual");


	}
	
	@Test
	@DisplayName("Método criar para conta - criarConta()")
	void criarConta() {

		HttpEntity<Conta> requisicao = new HttpEntity<Conta>(new Conta(null, "Catarina", 12394508402L, 87667322, 2800));
		ResponseEntity<Conta> resposta = testRestTemplate.exchange("/contas", HttpMethod.POST, requisicao, Conta.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode(), "Status Code da conta criada deve ser igual");
	}

	@Test
	@DisplayName("Método que atualiza conta por Id - atualizarConta()")
	void atualizarConta() {
		
		HttpEntity<Conta> requisicao = new HttpEntity<Conta>(new Conta(null, "Catarina", 12394508403L, 87667323, 2800));
		ResponseEntity<Conta> resposta = testRestTemplate.exchange("/contas", HttpMethod.POST, requisicao, Conta.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode(), "Status Code da conta criada deve ser igual");
		requisicao.getBody().setId(resposta.getBody().getId());


		ResponseEntity<Conta> resposta1 = testRestTemplate.exchange("/contas/{id}", HttpMethod.PUT, requisicao,
				Conta.class, resposta.getBody().getId());
		assertEquals(HttpStatus.CREATED, resposta1.getStatusCode(), "Status Code da conta deve ser igual");

	}

	@Test
	@DisplayName("Método que exlcluí conta por Id - deletar()")
	void deletar() {

		HttpEntity<Conta> requisicao = new HttpEntity<Conta>(new Conta(null, "Catarina", 12394508404L, 87667324, 2800));
		ResponseEntity<Conta> resposta = testRestTemplate.exchange("/contas", HttpMethod.POST, requisicao, Conta.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode(), "Status Code da conta criada deve ser igual");
		

		ResponseEntity<Void> resposta1 = testRestTemplate.exchange("/contas/{id}", HttpMethod.DELETE, null, Void.class,
				resposta.getBody().getId());	
		assertEquals(HttpStatus.OK, resposta1.getStatusCode(), "Status Code da conta deve ser igual");

	}

}
