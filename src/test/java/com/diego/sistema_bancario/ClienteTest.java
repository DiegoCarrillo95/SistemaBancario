package com.diego.sistema_bancario;

import static org.junit.Assert.*;

import org.junit.Test;


public class ClienteTest {
	
	double delta = 0.005;

	@Test
	public void criarClienteTest() {
		String nome = "abcdefg";
		Cliente cliente = new Cliente(nome);
		
		assertEquals(nome, cliente.getNome());
		assertEquals(0, cliente.getConta().getSaldo(),delta);
	}
	
	@Test
	public void equalsTest() {
		Cliente cliente1 = new Cliente("a");
		Cliente cliente2 = new Cliente("a");
		
		assertTrue(cliente1.equals(cliente2));
		assertTrue(cliente1.hashCode() == cliente2.hashCode());
	}
	
	
	@Test
	public void notEqualsTest() {
		Cliente cliente1 = new Cliente("a");
		Cliente cliente2 = new Cliente("b");
		
		assertFalse(cliente1.equals(cliente2));
		assertFalse(cliente1.hashCode() == cliente2.hashCode());
	}

}
