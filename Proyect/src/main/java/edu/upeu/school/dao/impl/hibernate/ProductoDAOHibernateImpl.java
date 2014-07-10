package edu.upeu.school.dao.impl.hibernate;


import java.util.List;

import org.springframework.stereotype.Repository;

import edu.upeu.school.dao.ProductoDAO;
import edu.upeu.school.domain.Cliente;
import edu.upeu.school.domain.Producto;

@Repository
public class ProductoDAOHibernateImpl extends
		GenericDaoHibernateImpl<Producto, String> implements ProductoDAO {

	public void eliminarVentaProducto(String idProducto, String idVenta) {
	}
	
public List<Producto> buscarPor( String valor) {
		
//		System.out.print("Holassssssssssssssssssssss");
		return getSession()
		  .createQuery("SELECT a FROM Producto a WHERE UPPER(a.descripcion) LIKE UPPER(:dato) ")
		        .setString("dato", "%"+valor+"%").list();
		
	} 
	
	public void removeP(Producto object) {
		// TODO Auto-generated method stub
		getSession().delete(object);
		getSession().flush();
//		super.remove(object);
	}
	
	
}
