package com.qintess.bilheteria.service;

import java.util.List;

import com.qintess.bilheteria.model.ItemPedido;

public interface ItemPedidoService {
	
void salvar(ItemPedido itemPedido);
	
	void editar(ItemPedido itemPedido);
	
	void excluir (Long id);
	
	ItemPedido buscarPorId(Long id);
	
	List<ItemPedido> buscarTodos();

}
