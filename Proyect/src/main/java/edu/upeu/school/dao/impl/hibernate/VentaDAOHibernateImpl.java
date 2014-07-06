package edu.upeu.school.dao.impl.hibernate;

import org.springframework.stereotype.Repository;

import edu.upeu.school.dao.VentaDAO;
import edu.upeu.school.domain.Venta;

@Repository
public class VentaDAOHibernateImpl extends
		GenericDaoHibernateImpl<Venta, String> implements VentaDAO {

}
