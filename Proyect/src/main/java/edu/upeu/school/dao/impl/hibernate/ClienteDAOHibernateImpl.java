package edu.upeu.school.dao.impl.hibernate;


import java.util.List;

import org.springframework.stereotype.Repository;

import edu.upeu.school.dao.ClienteDAO;
import edu.upeu.school.domain.Cliente;


@Repository
public class ClienteDAOHibernateImpl extends
		GenericDaoHibernateImpl<Cliente, String> implements ClienteDAO {
	

	public List<Cliente> buscarPor( String valor) {
		
//		System.out.print("Holassssssssssssssssssssss");
		return getSession()
		  .createQuery("SELECT a FROM Cliente a WHERE UPPER(a.nombre) LIKE UPPER(:dato) ")
		        .setString("dato", "%"+valor+"%").list();
		
	} 	
	
	//////////////////////////////////////////////////
	@Override
	public void remove(Cliente object) {
		// TODO Auto-generated method stub
		getSession().delete(object);
//		getSession().flush();
//		super.remove(object);
	}
	
	
	

}
