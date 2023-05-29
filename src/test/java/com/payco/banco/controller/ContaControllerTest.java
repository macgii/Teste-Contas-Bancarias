package com.payco.banco.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

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

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("Teste da classe ContaControllerTest")
public class ContaControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	@DisplayName("Método criar para conta - criarConta()")
	public void criarConta() {

		HttpEntity<Conta> requisicao = new HttpEntity<Conta>(new Conta(null, "Catarina", 12394508407L, 87667328, 2800));

		ResponseEntity<Conta> resposta = testRestTemplate.exchange("/contas", HttpMethod.POST, requisicao, Conta.class);

		assertEquals(HttpStatus.CREATED, resposta.getStatusCode(), "Status Code da conta criada deve ser igual");
	}

	@Test
	@DisplayName("Método que busca todas as contas - getAll()")
	public void getAll() {
		ResponseEntity<List<Conta>> resposta = testRestTemplate.exchange("/contas", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Conta>>() {
				});
		assertEquals(HttpStatus.OK, resposta.getStatusCode(), "Status Code da lista de contas deve ser igual");
	}

	@Test
	@DisplayName("Método que busca conta por Id - getById()")
	public void getById() {
		
		Conta conta = new Conta(1L, "Catarina", 12394508407L, 87667328, 1800);

		ResponseEntity<Conta> resposta = testRestTemplate.exchange("/contas/{id}", HttpMethod.GET, null, Conta.class,
				1);

		assertEquals(HttpStatus.OK, resposta.getStatusCode(), "Status Code da conta deve ser igual");
		assertEquals(conta.getId(), resposta.getBody().getId(), "Id da conta deve ser igual");
		assertEquals(conta.getTitular(), resposta.getBody().getTitular(), "Titular da conta deve ser igual");
		assertEquals(conta.getCpf(), resposta.getBody().getCpf(), "CPF da conta deve ser igual");
		assertEquals(conta.getNumeroConta(), resposta.getBody().getNumeroConta(), "Numero da conta da conta deve ser igual");
		assertEquals(conta.getSaldo(), resposta.getBody().getSaldo(), "Saldo da conta deve ser igual");


	}

	@Test
	@DisplayName("Método que atualiza conta por Id - atualizarConta()")
	public void atualizarConta() {

		HttpEntity<Conta> requisicao = new HttpEntity<Conta>(new Conta(null, "Catarina", 12394508407L, 87667328, 2800));

		ResponseEntity<Conta> resposta = testRestTemplate.exchange("/contas/{id}", HttpMethod.PUT, requisicao,
				Conta.class, 1);

		assertEquals(HttpStatus.CREATED, resposta.getStatusCode(), "Status Code da conta deve ser igual");

	}

	@Test
	@DisplayName("Método que exlcluí conta por Id - deletar()")
	public void deletar() {

		ResponseEntity<Void> resposta = testRestTemplate.exchange("/contas/{id}", HttpMethod.DELETE, null, Void.class,
				1);
		
		assertEquals(HttpStatus.OK, resposta.getStatusCode(), "Status Code da conta deve ser igual");

	}

}
