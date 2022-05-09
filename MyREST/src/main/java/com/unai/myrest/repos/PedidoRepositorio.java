package com.unai.myrest.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unai.myrest.modelo.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {


}
