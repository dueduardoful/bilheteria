package com.qintess.bilheteria.dao;

import java.util.List;

import com.qintess.bilheteria.model.ItemPedido;

public interface ItemPedidoDao {
	
public void save(ItemPedido itemPedido);

	
	public void update(ItemPedido itemPedido); 
		
	
	public void delete(Long id); 
	
	ItemPedido findById(Long id);
	
	List<ItemPedido> findAll();

}
