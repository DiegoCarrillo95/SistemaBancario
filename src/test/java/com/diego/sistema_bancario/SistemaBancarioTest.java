package com.diego.sistema_bancario;

import static org.junit.Assert.*;

import org.junit.Test;

public class SistemaBancarioTest {

	//Testes de integração: 
	
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
	
	@Test
	public void addClienteTeste() {
		//Arrange
		SistemaBancario sistema = new SistemaBancario();
		
		//Act
		sistema.addCliente("a");
		sistema.addCliente("b");
		
		//Assert
		assertEquals(2, sistema.getClientes().size());
	}
	
	
	@Test
	public void addClienteRepetidoTeste() {
		//Arrange
		SistemaBancario sistema = new SistemaBancario();
		
		//Act
		sistema.addCliente("a");
		sistema.addCliente("a");
		
		//Assert
		assertEquals(1, sistema.getClientes().size());
	}
	
	

}
