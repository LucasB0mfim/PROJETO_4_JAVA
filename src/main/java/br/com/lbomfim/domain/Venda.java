package br.com.lbomfim.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Lucas Bomfim
 */

@Entity
@Table(name = "TB_VENDA")
public class Venda {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_seq")
    @SequenceGenerator(name = "venda_seq", sequenceName = "seq_venda", initialValue = 1, allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente_fk", foreignKey = @ForeignKey(name = "fk_cliente_venda"), referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    @OneToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "TB_VENDA_PRODUTO",
            joinColumns = @JoinColumn(name = "id_venda_fk", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_produto_fk", referencedColumnName = "id")
        )
    private List<Produto> produtos = new ArrayList<>();
    
    @Column(name = "QUANTIDADE", nullable = false)
    private Integer quantidade;

    @Column(name = "VALOR_TOTAL", nullable = false)
    private Double valor_total;

    @Column(name = "DATA_VENDA", nullable = false)
    private Instant data_venda;
    
    public void adicionar_produto(Produto produto) {
        this.produtos.add(produto);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}

	public Instant getData_venda() {
		return data_venda;
	}

	public void setData_venda(Instant data_venda) {
		this.data_venda = data_venda;
	}
}
