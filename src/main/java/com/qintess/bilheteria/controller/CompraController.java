package com.qintess.bilheteria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.bilheteria.model.Evento;
import com.qintess.bilheteria.service.EventoService;

@Controller
@RequestMapping("/compras")
public class CompraController {
	
	@Autowired
	private EventoService eventoService;

	@GetMapping("/compras/{idevento}")
	public String compra(@PathVariable("idevento") Long idevento, Evento evento , ModelMap model) {
		model.addAttribute("compras", eventoService.buscarPorId(idevento));
		return "/compra/compra";
	}
	
	
}
