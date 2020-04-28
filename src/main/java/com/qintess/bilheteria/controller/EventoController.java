package com.qintess.bilheteria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qintess.bilheteria.model.CasaDeShow;
import com.qintess.bilheteria.model.Evento;
import com.qintess.bilheteria.service.CasaDeShowService;
import com.qintess.bilheteria.service.EventoService;

@Controller
@RequestMapping("/eventos")
public class EventoController {
	
	@Autowired
	private EventoService eventoService;
	@Autowired
	private CasaDeShowService casaShowService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Evento evento) {
		return "/evento/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("eventos", eventoService.buscarTodos());
		return "/evento/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Evento evento, BindingResult result , RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/evento/cadastro";
		}
		
		eventoService.salvar(evento);
		attr.addFlashAttribute("success", "Evento inserido com sucesso.");
		return "redirect:/eventos/cadastrar";
		
	}
	
	
	@GetMapping("/editar/{idevento}")
	public String preEditar(@PathVariable("idevento") Long idevento, ModelMap model) {
		model.addAttribute("evento", eventoService.buscarPorId(idevento));
		return "evento/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Evento evento, BindingResult result , RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/evento/cadastro";
		}
		
		eventoService.editar(evento);
		attr.addFlashAttribute("success", "Evento editado com sucesso!");
		return "redirect:/eventos/cadastrar";
	}
	
	@GetMapping("/excluir/{idevento}")
	public String excluir(@PathVariable("idevento") Long idevento, RedirectAttributes attr) {
				eventoService.excluir(idevento);
				attr.addFlashAttribute("success", "Evento excluído com sucesso!");
				return "redirect:/eventos/listar";
	}
	
	@GetMapping("/detalhes/{idevento}")
	public String detalhe(@PathVariable("idevento") Long idevento, Evento evento , ModelMap model) {
		model.addAttribute("eventos", eventoService.buscarPorId(idevento));
		return "/evento/detalhes";
	}
	
	
	

	@ModelAttribute("casasdeshow")
	public List<CasaDeShow> listaDeCasasDeShow(){
		return casaShowService.buscarTodos();
	}
	
}
