package com.unai.myrest.service;

import org.springframework.stereotype.Service;

import com.unai.myrest.modelo.Categoria;
import com.unai.myrest.repos.CategoriaRepositorio;
import com.unai.myrest.service.base.BaseService;

@Service
public class CategoriaServicio extends BaseService<Categoria, Long, CategoriaRepositorio>{

}

