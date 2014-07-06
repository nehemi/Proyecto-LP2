package edu.upeu.school.dao.impl.hibernate;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.upeu.school.dao.ProductoDAO;
import edu.upeu.school.domain.Producto;
import edu.upeu.school.domain.Venta;

@Repository
public class ProductoDAOHibernateImpl extends
		GenericDaoHibernateImpl<Producto, String> implements ProductoDAO {

	public void eliminarVentaProducto(String idProducto, String idVenta) {
//		Producto a = (Producto) getSession().createCriteria(Producto.class)
//				.add(Restrictions.idEq(new Long(idProducto))).uniqueResult();
//		for (Venta c : a.getVentas()) {
//			if (c.getId().toString().equals(idVenta)) {
//				a.getVentas().remove(c);
//			}
//		}
	}
}
