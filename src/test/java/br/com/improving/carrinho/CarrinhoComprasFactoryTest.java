package br.com.improving.carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarrinhoComprasFactoryTest {

	private CarrinhoComprasFactory factory;

	@BeforeEach
	void setup() {
		factory = new CarrinhoComprasFactory();
	}

	@Test
	void deveCriarNovoCarrinhoParaCliente() {
		CarrinhoCompras carrinho = factory.criar("cliente1");
		assertNotNull(carrinho);
	}

	@Test
	void deveRetornarMesmoCarrinhoParaMesmoCliente() {
		CarrinhoCompras carrinho1 = factory.criar("cliente1");
		CarrinhoCompras carrinho2 = factory.criar("cliente1");

		assertSame(carrinho1, carrinho2);
	}

	@Test
	void deveCalcularTicketMedioCorretamente() {
		CarrinhoCompras carrinho1 = factory.criar("cliente1");
		CarrinhoCompras carrinho2 = factory.criar("cliente2");

		carrinho1.adicionarItem(new Produto(1L, "Produto 1"), BigDecimal.valueOf(10.00), 2); // Total = 20.00
		carrinho2.adicionarItem(new Produto(2L, "Produto 2"), BigDecimal.valueOf(20.00), 1); // Total = 20.00

		assertEquals(BigDecimal.valueOf(20.00), factory.getValorTicketMedio()); // Total / 2 carrinhos
	}

	@Test
	void deveInvalidarCarrinhoDeCliente() {
		factory.criar("cliente1");
		assertTrue(factory.invalidar("cliente1"));
		assertFalse(factory.invalidar("cliente1")); // Já foi invalidado
	}
}
