package com.qintess.bilheteria.service;

import java.util.List;

import com.qintess.bilheteria.model.CasaDeShow;

public interface CasaDeShowService {
	
	void salvar(CasaDeShow casashow);
	
	void editar(CasaDeShow casashow);
	
	void excluir(Long id);
	
	CasaDeShow buscarPorId(Long id);
	
	List<CasaDeShow> buscarTodos();

	boolean casaDeShowTemEventos(Long id);
	
}
