package com.qintess.bilheteria.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ingresso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idingresso;
	
	@ManyToOne()
	@JoinColumn(name = "id_evento")
	private Evento evento;
	
	@OneToMany(mappedBy = "ingresso", fetch = FetchType.EAGER)
	private List<ItemPedido> listIngressos = new ArrayList<>();
	
	public Ingresso() {
	}

	public Ingresso(Long idingresso, Evento evento) {
		this.idingresso = idingresso;
	}

	public Long getIdingresso() {
		return idingresso;
	}

	public void setIdingresso(Long idingresso) {
		this.idingresso = idingresso;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "Ingresso [idingresso=" + idingresso + ", evento=" + evento + "]";
	}
	
	

}
