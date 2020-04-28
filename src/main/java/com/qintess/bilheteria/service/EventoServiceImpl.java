package com.qintess.bilheteria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qintess.bilheteria.dao.EventoDao;
import com.qintess.bilheteria.model.Evento;

@Service 
public class EventoServiceImpl implements EventoService {
	
	@Autowired
	private EventoDao dao;
	
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Evento evento) {
		dao.save(evento);
		
	}
	@Transactional(readOnly = false)
	@Override
	public void editar(Evento evento) {
		dao.update(evento);
		
	}
	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Evento buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Evento> buscarTodos() {
		return dao.findAll();
	}

}
