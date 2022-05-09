package com.unai.myrest.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unai.myrest.modelo.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
