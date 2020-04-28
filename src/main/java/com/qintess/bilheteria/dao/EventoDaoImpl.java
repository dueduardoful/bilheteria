package com.qintess.bilheteria.dao;

import org.springframework.stereotype.Repository;

import com.qintess.bilheteria.model.Evento;

@Repository
public class EventoDaoImpl extends AbastracDao<Evento, Long> implements EventoDao {

}
