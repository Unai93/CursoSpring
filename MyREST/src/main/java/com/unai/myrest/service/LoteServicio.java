package com.unai.myrest.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unai.myrest.dto.CreateLoteDTO;
import com.unai.myrest.error.LoteCreateException;
import com.unai.myrest.modelo.Lote;
import com.unai.myrest.repos.LoteRepositorio;
import com.unai.myrest.service.base.BaseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoteServicio extends BaseService<Lote, Long, LoteRepositorio> {

	private final ProductoServicio productoServicio;
	
	@Override
	public Optional<Lote> findById(Long id) {
		return repositorio.findByIdJoinFetch(id);
	}

	public Lote nuevoLote(CreateLoteDTO nuevoLote) {
		
		Lote l = Lote.builder()
					.nombre(nuevoLote.getNombre())
					.build();
		
		nuevoLote.getProductos().stream()
			.map(id -> {
				return productoServicio.findByIdConLotes(id).orElseThrow(() -> new LoteCreateException());
			})
			.forEach(l::addProducto);
			
		return save(l);
		
	}
}
