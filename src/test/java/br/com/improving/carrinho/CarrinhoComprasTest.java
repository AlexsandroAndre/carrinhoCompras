package br.com.improving.carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarrinhoComprasTest {

	private CarrinhoCompras carrinho;
	private Produto produto1;
	private Produto produto2;

	@BeforeEach
	void setup() {
		carrinho = new CarrinhoCompras();
		produto1 = new Produto(1L, "Produto 1");
		produto2 = new Produto(2L, "Produto 2");
	}

	@Test
	void deveAdicionarItemAoCarrinho() {
		carrinho.adicionarItem(produto1, BigDecimal.valueOf(10.50), 2);
		assertEquals(1, carrinho.getItens().size());
		assertEquals(BigDecimal.valueOf(21.00), carrinho.getValorTotal());
	}

	@Test
	void deveAtualizarQuantidadeEValorUnitarioSeProdutoJaExistir() {
		carrinho.adicionarItem(produto1, BigDecimal.valueOf(10.00), 2);
		carrinho.adicionarItem(produto1, BigDecimal.valueOf(12.00), 3);

		assertEquals(1, carrinho.getItens().size());
		assertEquals(BigDecimal.valueOf(60.00), carrinho.getValorTotal());
	}

	@Test
	void deveRemoverItemPeloProduto() {
		carrinho.adicionarItem(produto1, BigDecimal.valueOf(10.00), 2);
		assertTrue(carrinho.removerItem(produto1));
		assertEquals(0, carrinho.getItens().size());
	}

	@Test
	void deveRemoverItemPelaPosicao() {
		carrinho.adicionarItem(produto1, BigDecimal.valueOf(10.00), 2);
		carrinho.adicionarItem(produto2, BigDecimal.valueOf(20.00), 1);

		assertTrue(carrinho.removerItem(0)); // Remove o primeiro item
		assertEquals(1, carrinho.getItens().size());
		assertEquals(BigDecimal.valueOf(20.00), carrinho.getValorTotal());
	}

	@Test
	void deveCalcularValorTotalCorretamente() {
		carrinho.adicionarItem(produto1, BigDecimal.valueOf(15.00), 2);
		carrinho.adicionarItem(produto2, BigDecimal.valueOf(20.00), 1);

		assertEquals(BigDecimal.valueOf(50.00), carrinho.getValorTotal());
	}
}
