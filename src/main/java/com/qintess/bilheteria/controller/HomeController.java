package com.qintess.bilheteria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.bilheteria.service.EventoService;

@Controller
public class HomeController {
	@Autowired
	private EventoService eventoService;
	
	@RequestMapping("/")
	public String home(ModelMap model) {
		model.addAttribute("eventos", eventoService.buscarTodos());
		return "home";
	}

}
