package com.qintess.bilheteria.dao;

import java.util.List;

import com.qintess.bilheteria.model.Evento;

public interface EventoDao {
	
	void save(Evento evento);
	
	void update(Evento evento);
	
	void delete(Long id);
	
	Evento findById(Long id);
	
	List<Evento> findAll();
}
