package com.payco.banco.model;

public class ContaPoupanca extends Conta{

	private int aniversariopoupanca;

	public ContaPoupanca(Long Id, String titular, Long cpf, int numeroConta, float saldo,int aniversariopoupanca) {
		super(Id, titular, cpf, numeroConta, saldo);
		this.aniversariopoupanca = aniversariopoupanca;
	}

	public int getAniversariopoupanca() {
		return aniversariopoupanca;
	}

	public void setAniversariopoupanca(int aniversariopoupanca) {
		this.aniversariopoupanca = aniversariopoupanca;
	}
	
}