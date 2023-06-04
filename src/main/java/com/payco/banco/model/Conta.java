package com.payco.banco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="tb_contas")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 2)
	private String titular;
	
    @Min(10000000000L)
    @Max(99999999999L)
    @Column(name = "cpf", unique = true)
	private long cpf;
	
    @Min(10000000)
    @Max(99999999)
    @Column(name = "numeroConta", unique = true)
	private int numeroConta;
	
    @Min(0)
	private float saldo;
	
	public Conta() {
		
	}
	
	public Conta(Long id, @NotBlank @Size(min = 2) String titular,
			@Min(10000000000L) @Max(99999999999L) @NotNull long cpf,
			@Min(10000000) @Max(99999999) @NotNull int numeroConta, @Min(0) float saldo) {
		super();
		this.id = id;
		this.titular = titular;
		this.cpf = cpf;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {  
		return "(Id: " + this.getId() + ") (Titular: " + this.getTitular() + ") (CPF: " + this.getCpf() + ") (Numero Conta: " + this.getNumeroConta() + ") (Saldo: R$" + this.getSaldo() + ")";
	}

}