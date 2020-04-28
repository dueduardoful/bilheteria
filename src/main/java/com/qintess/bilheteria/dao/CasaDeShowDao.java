package com.qintess.bilheteria.dao;

import java.util.List;

import com.qintess.bilheteria.model.CasaDeShow;

public interface CasaDeShowDao {
	
	void save(CasaDeShow casashow);
	
	void update(CasaDeShow casashow);
	
	void delete(Long id);
	
	CasaDeShow findById(Long id);
	
	List<CasaDeShow> findAll();

}
