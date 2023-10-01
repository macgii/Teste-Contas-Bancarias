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
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
	
	public Conta(@NotBlank @Size(min = 2) String titular, @Min(10000000000L) @Max(99999999999L) long cpf,
			@Min(10000000) @Max(99999999) int numeroConta, @Min(0) float saldo) {
		this.titular = titular;
		this.cpf = cpf;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}	
}