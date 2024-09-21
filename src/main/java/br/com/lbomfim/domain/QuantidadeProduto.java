package br.com.lbomfim.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Lucas Bomfim 
 */

@Entity
@Table(name = "TB_QUANTIDADE_PRODUTO")
public class QuantidadeProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_produto_seq")
    @SequenceGenerator(name = "venda_produto_seq", sequenceName = "seq_venda_produto", initialValue = 1, allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    public QuantidadeProduto(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double calcularValor() {
        return produto.getValor() * quantidade;
    }
}

