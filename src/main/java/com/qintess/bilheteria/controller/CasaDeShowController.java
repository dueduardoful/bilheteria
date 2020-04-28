package com.qintess.bilheteria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qintess.bilheteria.model.CasaDeShow;
import com.qintess.bilheteria.service.CasaDeShowService;

@Controller
@RequestMapping("/casasdeshow")
public class CasaDeShowController {
	
	@Autowired
	private CasaDeShowService casaDeShowService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(CasaDeShow casadeshow, Model model) {
		casadeshow = new CasaDeShow();
		model.addAttribute("casadeshow", casadeshow);
		return "/casadeshow/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("casasdeshow", casaDeShowService.buscarTodos());
		return "/casadeshow/lista";
	}
	
	
	@PostMapping("/salvar")
	public String salvar(@Valid CasaDeShow casadeshow, BindingResult result , RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/casadeshow/cadastro";
		}
		casaDeShowService.salvar(casadeshow);
		attr.addFlashAttribute("success", "Casa Show inserida com sucesso!");
		return "redirect:/casasdeshow/cadastrar";
	}
	
	@GetMapping("/editar/{idcasashow}")
	public String preEditar(@PathVariable("idcasashow") Long idcasashow, ModelMap model) {
		model.addAttribute("casadeshow", casaDeShowService.buscarPorId(idcasashow));
		
		return "/casadeshow/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid CasaDeShow casadeshow, BindingResult result , RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/casadeshow/cadastro";
		}
		
		casaDeShowService.editar(casadeshow);
		attr.addFlashAttribute("success", "Casa Show editada com sucesso!");
		return "redirect:/casasdeshow/cadastrar";
	}
	
	@GetMapping("/excluir/{idcasashow}")
	public String excluir(@PathVariable("idcasashow") Long idcasashow, ModelMap model) {
		
		if(casaDeShowService.casaDeShowTemEventos(idcasashow)) {
			model.addAttribute("fail", "Casa Show não foi removida. Possui Eventos Vinculados.");
		}
		else {
			casaDeShowService.excluir(idcasashow);
			model.addAttribute("success", "Casa Show excluída com sucesso!");
		}
		return listar(model);
	}

}
