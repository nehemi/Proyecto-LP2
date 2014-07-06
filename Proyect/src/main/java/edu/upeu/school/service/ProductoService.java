package edu.upeu.school.service;

import java.util.List;

import edu.upeu.school.web.form.ProductoForm;

public interface ProductoService {

	List<ProductoForm> listarProductos();

	void guardarProducto(ProductoForm af);

	ProductoForm getProductoPorId(String id);

}
