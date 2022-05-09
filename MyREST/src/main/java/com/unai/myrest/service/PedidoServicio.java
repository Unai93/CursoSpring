package com.unai.myrest.service;

import org.springframework.stereotype.Service;

import com.unai.myrest.modelo.Pedido;
import com.unai.myrest.repos.PedidoRepositorio;
import com.unai.myrest.service.base.BaseService;

@Service
public class PedidoServicio extends BaseService<Pedido, Long, PedidoRepositorio> {

}

