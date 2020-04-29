package com.qintess.bilheteria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qintess.bilheteria.model.Evento;
import com.qintess.bilheteria.model.Ingresso;
import com.qintess.bilheteria.model.ItemPedido;
import com.qintess.bilheteria.model.Usuario;
import com.qintess.bilheteria.repository.UsuarioRepository;
import com.qintess.bilheteria.service.EventoService;
import com.qintess.bilheteria.service.ItemPedidoService;

@Controller
@RequestMapping("/compras")
public class CompraController {
	
	@Autowired
	private UsuarioRepository usuario;
	
	@Autowired
	private EventoService eventoService;
	@Autowired
	private ItemPedidoService servicePedido;

	@GetMapping("/compras/{idevento}")
	public String compra(@PathVariable("idevento") Long idevento, Evento evento , ModelMap model) {
		model.addAttribute("eventos", eventoService.buscarPorId(idevento));
		model.addAttribute("usuarios", usuario.findAll());
		return "/compra/compra";
	}
	@RequestMapping("/finalizar/{idevento}")
	public String finalizar(@PathVariable("idevento") Long idevento, @RequestParam(value="quantidade")int quantidade, 
			// @RequestParam(value="usuario")Long idusuario, 
			Evento evento,
			ModelMap model) {
			evento = eventoService.buscarPorId(idevento);
			ItemPedido itempedido = new ItemPedido();
			itempedido.setQuantidade(quantidade);
			Ingresso ingresso = new Ingresso();
			ingresso.setEvento(evento);
			itempedido.setIngresso(ingresso);
			double total = evento.getPreco()*quantidade;
			itempedido.setSub_total(total);
			int ingressos = evento.getIngressos()- quantidade;
			evento.setIngressos(ingressos);
		//	Usuario u = usuario.findById(idusuario).orElse(null);
			
			eventoService.salvar(evento);
			servicePedido.salvar(itempedido);
			
			model.addAttribute("evento", evento);
			model.addAttribute("itempedido", itempedido);

			// criar pedido
			// criar item pedido
			// criar ingresso
			// subtrair a quantidade de ingresso vendido
			
		return "/compra/finalizar";
		
	}
	
	@GetMapping("/final/{idevento}")     
	public String fim(@PathVariable("idevento") Long idevento, @RequestParam(value="quantidade")int quantidade,
			Evento evento,
			ModelMap model) {
		evento = eventoService.buscarPorId(idevento);
		ItemPedido itempedido = new ItemPedido();
		itempedido.setQuantidade(quantidade);
		Ingresso ingresso = new Ingresso();
		ingresso.setEvento(evento);
		itempedido.setIngresso(ingresso);
		double total = evento.getPreco()*quantidade;
		itempedido.setSub_total(total);
		int ingressos = evento.getIngressos()- quantidade;
		evento.setIngressos(ingressos);
		model.addAttribute("evento", evento);
		model.addAttribute("itempedido", itempedido);
		return "/compra/finalizar";
		}
	
	@GetMapping("/subtotal")
	public String subtotal() {
		return "/compra/finalizar";
	}	
}
