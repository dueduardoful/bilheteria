package com.qintess.bilheteria.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_itemPedido;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_ingresso")
	private Ingresso ingresso;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	@Column(nullable = false)
	private int quantidade;
	
	@Column(nullable = false, length = 10, scale = 2)
	private Double sub_total;
	
	public ItemPedido() {
	}
	
	public ItemPedido(Long id_itemPedido, int quantidade, Double sub_total) {
		this.id_itemPedido = id_itemPedido;
		this.quantidade = quantidade;
		this.sub_total = sub_total;
	}

	public Long getId_itemPedido() {
		return id_itemPedido;
	}

	public void setId_itemPedido(Long id_itemPedido) {
		this.id_itemPedido = id_itemPedido;
	}

	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getSub_total() {
		return sub_total;
	}

	public void setSub_total(Double sub_total) {
		this.sub_total = sub_total;
	}

	@Override
	public String toString() {
		return "ItemPedido [id_itemPedido=" + id_itemPedido + ", ingresso=" + ingresso + ", pedido=" + pedido
				+ ", quantidade=" + quantidade + ", sub_total=" + sub_total + "]";
	}
	
	
	
	
	
	
	
	}
	

