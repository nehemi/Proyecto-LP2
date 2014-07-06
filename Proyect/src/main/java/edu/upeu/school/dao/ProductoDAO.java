package edu.upeu.school.dao;

import edu.upeu.school.domain.Producto;

public interface ProductoDAO extends GenericDao<Producto, String> {

	void eliminarVentaProducto(String idProducto, String idVenta);

}
