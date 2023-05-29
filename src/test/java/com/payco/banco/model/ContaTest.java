package com.payco.banco.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste da classe ContaTest")
public class ContaTest {

	Conta conta = new Conta(1L, "Lia Martins", 62905480886L, 82285010, 3800);

	@Test
	@DisplayName("Método retorna Id - getId()")
	public void getId() {
		assertEquals(1L, conta.getId(), "Id deve ser igual");
	}
	
	@Test
	@DisplayName("Método altera Id - setId()")
	public void setId() {
		conta.setId(2L);
		assertEquals(2L, conta.getId(), "Id alterado deve ser igual");
	}

	@Test
	@DisplayName("Método retorna Titular - getTitular()")
	public void getTitular() {
		assertEquals("Lia Martins", conta.getTitular(), "Titular deve ser igual");
	}

	@Test
	@DisplayName("Método altera Titular - setTitular()")
	public void setTitular() {
		conta.setTitular("Luana Martins");
		assertEquals("Luana Martins", conta.getTitular(), "Titular alterado deve ser igual");
	}

	@Test
	@DisplayName("Método retorna CPF - getCpf()")
	public void getCpf() {
		assertEquals(62905480886L, conta.getCpf(), "CPF deve ser igual");
	}

	@Test
	@DisplayName("Método altera CPF - setCpf()")
	public void setCpf() {
		conta.setCpf(44986530822L);
		assertEquals(44986530822L, conta.getCpf(), "CPF alterado deve ser igual");
	}

	@Test
	@DisplayName("Método retorna número da conta - getNumeroConta()")
	public void getNumeroConta() {
		assertEquals(82285010, conta.getNumeroConta(), "Número da conta deve ser igual");
	}

	@Test
	@DisplayName("Método altera número da conta - setNumeroConta()")
	public void setNumeroConta() {
		conta.setNumeroConta(40282230);
		assertEquals(40282230, conta.getNumeroConta(), "Número da conta alterada deve ser igual");
	}

	@Test
	@DisplayName("Método retorna saldo da conta - getSaldo()")
	public void getSaldo() {
		assertEquals(3800, conta.getSaldo(), "Saldo da conta deve ser igual");
	}

	@Test
	@DisplayName("Método altera saldo da conta - setSaldo()")
	public void setSaldo() {
		conta.setSaldo(2500);
		assertEquals(2500, conta.getSaldo(), "Saldo da conta alterada deve ser igual");
	}
	
	@Test
	@DisplayName("Método retorna conta convertida para string - toString()")
	public void toString1() {  
		String contaConvertida = "(Id: " + conta.getId() + ") " + "(Titular: " + conta.getTitular() + ") " + "(CPF: " + conta.getCpf() + ") " + "(Numero Conta: " + conta.getNumeroConta() + ") " + "(Saldo: R$" + conta.getSaldo() + ")";
		assertEquals(contaConvertida, conta.toString(), "Conta convertida deve ser igual");
	}
	
}
