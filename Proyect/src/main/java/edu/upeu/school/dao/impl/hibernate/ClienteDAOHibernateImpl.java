package edu.upeu.school.dao.impl.hibernate;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.upeu.school.dao.ClienteDAO;
import edu.upeu.school.domain.Cliente;


@Repository
public class ClienteDAOHibernateImpl extends
		GenericDaoHibernateImpl<Cliente, String> implements ClienteDAO {
	
//	public void eliminarCliente(String id) {
//		Cliente a = (Cliente) getSession().createCriteria(Cliente.class)
//				.add(Restrictions.idEq(new Long(id))).uniqueResult();
//		for (Cliente c : a.getCliente()) {
//			if (c.getId().toString().equals(idVenta)) {
//				a.getVentas().remove(c);
//			}
//		}
//	}

}
