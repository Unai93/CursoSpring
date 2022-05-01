package com.unai.secondhandmarket.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unai.secondhandmarket.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findFirstByEmail(String email);

}