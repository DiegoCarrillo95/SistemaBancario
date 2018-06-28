package com.diego.sistema_bancario;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {
	@Getter
	@EqualsAndHashCode.Include
	private String nome;

	@Getter
	private ContaBancaria conta;

	public Cliente(String nome) {
		conta = new ContaBancaria();
		this.nome = nome;
	}
}
