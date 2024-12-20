package br.com.improving.carrinho;

import java.util.Objects;

/**
 * Classe que representa um produto que pode ser adicionado
 * como item ao carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 */
public class Produto {

    private Long codigo;
    private String descricao;

    /**
     * Construtor da classe Produto.
     *
     * @param codigo
     * @param descricao
     */
    public Produto(Long codigo, String descricao) {
		if (codigo == null || descricao == null || descricao.isEmpty()) {
			throw new IllegalArgumentException("Código e descrição não podem ser nulos ou vazios.");
		}
		this.codigo = codigo;
		this.descricao = descricao;
    }

    /**
     * Retorna o código da produto.
     *
     * @return Long
     */
    public Long getCodigo() {
		return codigo;
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return String
     */
    public String getDescricao() {
		return descricao;
    }

	/**
	 * Dois produtos são considerados iguais se possuem o mesmo código.
	 *
	 * @param o Objeto a ser comparado.
	 * @return true se os produtos possuem o mesmo código, caso contrário false.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Produto produto = (Produto) o;
		return Objects.equals(codigo, produto.codigo);
	}

	/**
	 * Gera o hashCode baseado no código do produto.
	 *
	 * @return int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	/**
	 * Representação textual do produto.
	 *
	 * @return String contendo o código e a descrição do produto.
	 */
	@Override
	public String toString() {
		return "Produto{" +
				"codigo=" + codigo +
				", descricao='" + descricao + '\'' +
				'}';
	}
}