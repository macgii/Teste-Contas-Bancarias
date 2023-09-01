package com.payco.banco.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.payco.banco.model.Conta;
import com.payco.banco.repository.ContaRepository;
import com.payco.banco.util.Util;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	public void sacar(float valorSaque, Conta conta) {

		logger.info("ContaService: Iniciando método sacar() - valorSaque = {}, conta = {}", valorSaque, conta);

		if (conta.getSaldo() > valorSaque) {
			conta.setSaldo(conta.getSaldo() - valorSaque);
		}
	}

	public void depositar(float valorDeposito, Conta conta) {

		logger.info("ContaService: Iniciando método depositar() - valorDeposito = {}, conta = {}", valorDeposito,
				conta);

		conta.setSaldo(conta.getSaldo() + valorDeposito);
	}

	public float consultarSaldo(Conta conta) {

		logger.info("ContaService: Iniciando método consultarSaldo() - conta = {}", conta);

		return conta.getSaldo();
	}

	private static final Logger logger = LoggerFactory.getLogger(ContaService.class);

	public ResponseEntity<Conta> servicos(String opcao, float valor, Long id) {

		Util.processarData(opcao);
		logger.info("ContaService: Iniciando método servicos() - opcao = {}, valor = {}, id = {}", opcao, valor, id);

		Optional<Conta> resposta = contaRepository.findById(id);
		if (resposta.isPresent()) {
			Conta conta = resposta.get();

			switch (opcao) {
			case "consulta":
				consultarSaldo(conta);
				break;
			case "deposito":
				depositar(valor, conta);
				contaRepository.save(conta);
				break;
			case "saque":
				sacar(valor, conta);
				contaRepository.save(conta);
				break;
			default:
				break;
			}
			return ResponseEntity.ok(conta);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

}