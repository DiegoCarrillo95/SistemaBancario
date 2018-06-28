package com.diego.sistema_bancario;

import lombok.Getter;
import lombok.Setter;

public class ContaBancaria {
	
	@Getter @Setter
	private double saldo;
	
	public void deposito(double valor) {
		saldo = saldo + valor;
	}
	
	public boolean saque(double valor) {
		if(valor <= saldo) {
			saldo = saldo - valor;
			return true;
		}
		return false;
	}
}
