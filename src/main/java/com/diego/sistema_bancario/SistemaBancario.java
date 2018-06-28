package com.diego.sistema_bancario;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

public class SistemaBancario {
	@Getter
	private Set<Cliente> clientes;

	public SistemaBancario() {
		clientes = new HashSet<>();
	}

	public void addCliente(String nome) {
		clientes.add(new Cliente(nome));
	}

	public boolean transacao(Cliente clienteDebito, Cliente clienteCredito, double valor) {

		if (clienteDebito.getConta().getSaldo() > valor) {
			clienteDebito.getConta().saque(valor);
			clienteCredito.getConta().deposito(valor);
			return true;
		}
		return false;
	}

}
