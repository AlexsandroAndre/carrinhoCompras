package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;

    /**
     * Construtor da classe Item.
     * 
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
		if (produto == null) {
			throw new IllegalArgumentException("Produto não pode ser nulo.");
		}
		if (valorUnitario == null || valorUnitario.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Valor unitário deve ser maior que zero.");
		}
		if (quantidade <= 0) {
			throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
		}

		this.produto = produto;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
    }

    /**
     * Retorna o produto.
     *
     * @return Produto
     */
    public Produto getProduto() {
		return produto;
    }

    /**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorUnitario() {
		return valorUnitario;
    }

    /**
     * Retorna a quantidade dos item.
     *
     * @return int
     */
    public int getQuantidade() {
		return quantidade;
    }

    /**
     * Retorna o valor total do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
		return valorUnitario.multiply(BigDecimal.valueOf(quantidade));

    }

	/**
	 * Sobrescreve o método equals para comparar itens pelo produto.
	 *
	 * @param o Objeto a ser comparado.
	 * @return true se os itens tiverem o mesmo produto, caso contrário false.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Item item = (Item) o;
		return Objects.equals(produto, item.produto);
	}

	/**
	 * Sobrescreve o método hashCode com base no produto.
	 *
	 * @return int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(produto);
	}

	/**
	 * Representação textual do item.
	 *
	 * @return String com informações do produto, valor unitário e quantidade.
	 */
	@Override
	public String toString() {
		return "Item{" +
				"produto=" + produto +
				", valorUnitario=" + valorUnitario +
				", quantidade=" + quantidade +
				", valorTotal=" + getValorTotal() +
				'}';
	}
}
