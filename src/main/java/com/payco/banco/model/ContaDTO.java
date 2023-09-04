package com.payco.banco.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaDTO {
	
	private Long id;
	private String titular;
	private long cpf;
	private int numeroConta;		
}
