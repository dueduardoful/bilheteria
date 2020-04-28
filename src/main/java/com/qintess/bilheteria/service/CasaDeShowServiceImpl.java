package com.qintess.bilheteria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qintess.bilheteria.dao.CasaDeShowDao;
import com.qintess.bilheteria.model.CasaDeShow;

@Service
public class CasaDeShowServiceImpl implements CasaDeShowService {
	
	@Autowired
	private CasaDeShowDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(CasaDeShow casashow) {
		dao.save(casashow);
	}
	
	@Transactional(readOnly = false)
	@Override
	public void editar(CasaDeShow casashow) {
		dao.update(casashow);
	}
	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}
	@Transactional(readOnly = true)
	@Override
	public CasaDeShow buscarPorId(Long id) {
		return dao.findById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<CasaDeShow> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean casaDeShowTemEventos(Long idcasashow) {
		if(buscarPorId(idcasashow).getListEventos().isEmpty()) {
			return false;
		}
		return true;
	}

}
