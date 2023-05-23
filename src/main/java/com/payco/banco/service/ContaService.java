package com.payco.banco.service;

import org.springframework.stereotype.Service;

import com.payco.banco.model.Conta;

@Service
public class ContaService{
	
	public void sacar(float valorSaque, Conta conta) {
		
		if(conta.getSaldo() > valorSaque) {
			conta.setSaldo(conta.getSaldo() - valorSaque);
		}
	}
	
	public void depositar(float valorDeposito, Conta conta) {
		
		conta.setSaldo(conta.getSaldo() + valorDeposito);
	}
	
	public float consultarSaldo(Conta conta) {
		
		return conta.getSaldo();
	}
}