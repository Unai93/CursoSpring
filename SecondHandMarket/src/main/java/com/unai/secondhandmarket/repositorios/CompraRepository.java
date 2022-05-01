package com.unai.secondhandmarket.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unai.secondhandmarket.modelo.Compra;
import com.unai.secondhandmarket.modelo.Usuario;

public interface CompraRepository extends JpaRepository<Compra, Long>{

	List<Compra> findByPropietario(Usuario propietario);
	
}