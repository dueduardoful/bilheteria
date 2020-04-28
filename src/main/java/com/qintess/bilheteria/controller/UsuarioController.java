package com.qintess.bilheteria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qintess.bilheteria.model.Usuario;
import com.qintess.bilheteria.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	
	//injeção de dependencia
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@RequestMapping(method = RequestMethod.GET, value ="/cadastrousuario")
	public String inicio() {
		return "cadastro/cadastrousuario";
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value ="/salvarusuario")
	public String salvar(Usuario usuario) {
		usuarioRepository.save(usuario);
		return "cadastro/cadastrousuario";
	}
	 
	@RequestMapping(method = RequestMethod.GET, value = "/listausuarios")
	public ModelAndView usuarios() {
		ModelAndView andView = new ModelAndView("cadastro/cadastrousuario");
		Iterable<Usuario> usuariosIt = usuarioRepository.findAll();
		andView.addObject("usuarios", usuariosIt);
		return andView;
	}
	
	
}
