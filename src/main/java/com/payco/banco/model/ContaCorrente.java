package com.payco.banco.model;

public class ContaCorrente extends Conta{

	private float limiteConta;

	public ContaCorrente(Long id, String titular, Long cpf, int numeroConta, float saldo, float limiteConta) {
		super(id, titular, cpf, numeroConta, saldo);
		this.limiteConta = limiteConta;
	}

	public float getLimiteConta() {
		return limiteConta;
	}

	public void setLimiteConta(float limiteConta) {
		this.limiteConta = limiteConta;
	}
	
}