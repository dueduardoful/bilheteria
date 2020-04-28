package com.qintess.bilheteria.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idpedido;

	@Column(nullable = false, length = 10, scale = 2)
	private Double total;
	
	@Column(nullable = false)
	private LocalDate data_compra;
	
	@ManyToOne()
	@JoinColumn(name = "id_usuario")
	private Usuario Usuario;

	public Pedido() {
	}

	public Pedido(Long idpedido, Double total, LocalDate data_compra) {
		this.idpedido = idpedido;
		this.total = total;
		this.data_compra = data_compra;
	}

	public Long getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(Long idpedido) {
		this.idpedido = idpedido;
	}

	public Double getTotal() {
		Evento evento = new Evento();
		ItemPedido itempedido = new ItemPedido();
		return total = evento.getPreco()*itempedido.getQuantidade();
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LocalDate getData_compra() {
		return data_compra;
	}

	public void setData_compra(LocalDate data_compra) {
		this.data_compra = data_compra;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	@Override
	public String toString() {
		return "Pedido [idpedido=" + idpedido + ", total=" + total + ", data_compra=" + data_compra + ", Usuario="
				+ Usuario + "]";
	}
	
	
}
