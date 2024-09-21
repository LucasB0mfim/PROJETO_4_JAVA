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
@Table(name = "TB_VENDA_PRODUTO")
public class VendaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_produto_seq")
    @SequenceGenerator(name = "venda_produto_seq", sequenceName = "seq_venda_produto", initialValue = 1, allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    public VendaProduto(Produto produto, Venda venda, Integer quantidade) {
        this.produto = produto;
        this.venda = venda;
        this.quantidade = quantidade;
    }
    
    public Double calcularValor() {
        return this.produto.getValor() * this.quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}

