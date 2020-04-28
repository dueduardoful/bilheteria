package com.qintess.bilheteria.service;

import java.util.List;

import com.qintess.bilheteria.model.Evento;

public interface EventoService {
	
	void salvar(Evento evento);
	
	void editar(Evento evento);
	
	void excluir(Long id);
	
	Evento buscarPorId(Long id);
	
	List<Evento> buscarTodos();

}
