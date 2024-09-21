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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "tb_venda_produto",
        joinColumns = @JoinColumn(name = "venda_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<QuantidadeProduto> vendaProdutos = new ArrayList<>();

    @Column(name = "VALOR_TOTAL", nullable = false)
    private Double valor_total = 0d;

    @Column(name = "DATA_VENDA", nullable = false)
    private Instant data_venda;

    public void adicionarProduto(Produto produto, Integer quantidade) {
        QuantidadeProduto vendaProduto = new QuantidadeProduto(produto, quantidade);
        this.vendaProdutos.add(vendaProduto);
        this.valor_total += vendaProduto.calcularValor();
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

	public List<QuantidadeProduto> getVendaProdutos() {
		return vendaProdutos;
	}

	public void setVendaProdutos(List<QuantidadeProduto> vendaProdutos) {
		this.vendaProdutos = vendaProdutos;
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
