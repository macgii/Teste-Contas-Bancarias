package com.payco.banco.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.payco.banco.model.Conta;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("Teste da classe ContaServiceTest")
class ContaServiceTest {
	
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


}
