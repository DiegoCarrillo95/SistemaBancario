package com.diego.sistema_bancario;

import static org.junit.Assert.*;

import org.junit.Test;

import com.diego.sistema_bancario.ContaBancaria;

public class ContaBancariaTest {

	double delta = 0.005;
	
	@Test
	public void depositoTest(){
		ContaBancaria conta = new ContaBancaria();
		
		conta.deposito(200.00);
		
		assertEquals(200.00, conta.getSaldo(), delta);   
	}
	
	@Test
	public void saqueTest(){
		ContaBancaria conta = new ContaBancaria();
		boolean ret; 
		
		conta.deposito(200.00);
		
		ret = conta.saque(100.00);
		
		assertEquals(100.00, conta.getSaldo(), delta);   
		assertTrue(ret);   
	}
	
	@Test
	public void saqueSemSaldoTest(){
		ContaBancaria conta = new ContaBancaria();
		boolean ret; 
		
		ret = conta.saque(100.00);
		
		assertEquals(0, conta.getSaldo(), delta);   
		assertFalse(ret);   
	}
	
}

