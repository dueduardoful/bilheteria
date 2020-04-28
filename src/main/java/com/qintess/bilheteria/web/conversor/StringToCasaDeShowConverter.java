package com.qintess.bilheteria.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.qintess.bilheteria.model.CasaDeShow;
import com.qintess.bilheteria.service.CasaDeShowService;

@Component
public class StringToCasaDeShowConverter implements Converter<String, CasaDeShow> {

	@Autowired
	private CasaDeShowService service;

	@Override
	public CasaDeShow convert(String casashow) {
		if(casashow.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(casashow);
		return service.buscarPorId(id);
	}

}
