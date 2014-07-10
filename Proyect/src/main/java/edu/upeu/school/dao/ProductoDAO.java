package edu.upeu.school.dao;

import java.util.List;

import edu.upeu.school.domain.Cliente;
import edu.upeu.school.domain.Producto;

public interface ProductoDAO extends GenericDao<Producto, String> {

	void eliminarVentaProducto(String idProducto, String idVenta);
	void removeP(Producto object);
	List<Producto> buscarPor( String valor);

}
