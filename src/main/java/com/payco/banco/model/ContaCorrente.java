package com.payco.banco.model;

public class ContaCorrente extends Conta{

	private float limiteConta;

	public ContaCorrente(Long id, String titular, int numeroConta, float saldo, float limiteConta) {
		super(id, titular, numeroConta, saldo);
		this.limiteConta = limiteConta;
	}

	public float getLimiteConta() {
		return limiteConta;
	}

	public void setLimiteConta(float limiteConta) {
		this.limiteConta = limiteConta;
	}
	
	@Override
	public String toString() {  
		return "Minha conta: \nId: " + super.getId() + "\nTitular: " + super.getTitular() + "\nNumero Conta: " + super.getNumeroConta() + "\nSaldo: R$" + super.getSaldo() + "\nLimite: R$" + this.limiteConta;
	}
	
}