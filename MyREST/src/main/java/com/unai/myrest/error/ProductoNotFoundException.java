package com.unai.myrest.error;

public class ProductoNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 43876691117560211L;

	
	public ProductoNotFoundException(Long id) {
		super("No se puede encontrar el producto con la ID: " + id);
	}


	public ProductoNotFoundException() {
		super("No se pueden encontrar productos");
	}
}
