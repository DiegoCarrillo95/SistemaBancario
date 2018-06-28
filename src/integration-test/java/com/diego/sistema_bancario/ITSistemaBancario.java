package com.diego.sistema_bancario;

import static org.junit.Assert.*;

import org.junit.Test;

public class ITSistemaBancario {

	double delta = 0.005;

	@Test
	public void transacaoTest() {
		//Arrange
		SistemaBancario sistema = new SistemaBancario();
		Cliente cliente1 = new Cliente("a");
		Cliente cliente2 = new Cliente("b");
		
		//Act
		cliente1.getConta().deposito(100);
		boolean ret = sistema.transacao(cliente1, cliente2, 50);
		
		//Assert
		assertTrue(ret);
		assertEquals(50 ,cliente1.getConta().getSaldo(), delta);
		assertEquals(50 ,cliente2.getConta().getSaldo(), delta);
	}
	
	@Test
	public void transacaoSemSaldoTest() {
		//Arrange
		SistemaBancario sistema = new SistemaBancario();
		Cliente cliente1 = new Cliente("a");
		Cliente cliente2 = new Cliente("b");
		
		//Act
		cliente1.getConta().deposito(100);
		boolean ret = sistema.transacao(cliente1, cliente2, 150);
		
		//Assert
		assertFalse(ret);
		assertEquals(100 ,cliente1.getConta().getSaldo(), delta);
		assertEquals(0 ,cliente2.getConta().getSaldo(), delta);
	}

}
