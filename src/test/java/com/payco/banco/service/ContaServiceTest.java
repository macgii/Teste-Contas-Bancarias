package com.payco.banco.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.payco.banco.model.Conta;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("Teste da classe ContaServiceTest")
class ContaServiceTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	ContaService contaService;
	
	@Test
	@DisplayName("Método que consulta saldo - consultaSaldo()")
	void consultarSaldo() {
		Conta conta = new Conta(1L, "Ana Catarina", 12394508407L, 87667328, 1800);
		float saldo = contaService.consultarSaldo(conta);
		
		assertEquals(saldo, conta.getSaldo(), "Saldo da conta deve ser igual");
	}
	
	@Test
	@DisplayName("Método que adiciona saldo - depositar()")
	void depositar() {
		Conta conta = new Conta(1L, "Ana Catarina", 12394508407L, 87667328, 1800);
		contaService.depositar(1000, conta);
		assertEquals(2800, conta.getSaldo(), "Saldo da conta deve ser igual");
	}
	
	@Test
	@DisplayName("Método que subtrai saldo - sacar()")
	void sacar() {
		Conta conta = new Conta(1L, "Ana Catarina", 12394508407L, 87667328, 1800);
		contaService.sacar(200, conta);
		assertEquals(1600, conta.getSaldo(), "Saldo da conta deve ser igual");
	}

	@Test
	@DisplayName("Método que escolhe serviço - servicos()")
	void sevicos() {
		HttpEntity<Conta> requisicao = new HttpEntity<Conta>(new Conta(null, "Catarina", 12394508409L, 87667322, 2800));
		ResponseEntity<Conta> resposta = testRestTemplate.exchange("/contas", HttpMethod.POST, requisicao, Conta.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode(), "Status Code da conta criada deve ser igual");
		Long id = resposta.getBody().getId();

		ResponseEntity<Conta> consulta = contaService.servicos("consulta", 0, id);
		assertEquals(HttpStatus.OK, consulta.getStatusCode(), "Status Code da consulta deve ser igual");
		
		ResponseEntity<Conta> deposito = contaService.servicos("deposito", 100, id);
		assertEquals(HttpStatus.OK, deposito.getStatusCode(), "Status Code do deposito deve ser igual");

		ResponseEntity<Conta> saque = contaService.servicos("saque", 50, id);
		assertEquals(HttpStatus.OK, saque.getStatusCode(), "Status Code do saque deve ser igual");
		
		ResponseEntity<Conta> consulta2 = contaService.servicos("deposito", 0, 0L);
		assertEquals(HttpStatus.NOT_FOUND, consulta2.getStatusCode(), "Status Code do erro deve ser igual");
	}

}
