package edu.upeu.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.upeu.school.dao.ClienteDAO;
import edu.upeu.school.domain.Cliente;
import edu.upeu.school.service.ClienteService;
import edu.upeu.school.web.form.ClienteForm;

@Service
@Transactional(readOnly = true)
public class ClienteServiceImpl implements ClienteService {

	
	@Autowired
	private ClienteDAO clienteDAO;

	public List<ClienteForm> getListaClientes() {

		List<ClienteForm> lf = new ArrayList<ClienteForm>();

		List<Cliente> lista = clienteDAO.getAll(Cliente.class);

		for (Cliente d : lista) {
			ClienteForm df = new ClienteForm();
			df.setId(d.getId());
			df.setNombre(d.getNombre());
			df.setApePat(d.getApePat());
			df.setApeMat(d.getApeMat());
			df.setDni(d.getDni());
			df.setRuc(d.getRuc());
			df.setEmail(d.getEmail());
			df.setDireccion(d.getDireccion());
			df.setTelefono(d.getTelefono());

			lf.add(df);
		}

		return lf;
	}

	@Transactional(readOnly = false)
	public void guardarCliente(ClienteForm df) {
		Cliente d = new Cliente();
		d.setApePat(df.getApePat());
		d.setApeMat(df.getApeMat());
		d.setDni(df.getDni());
		d.setRuc(df.getRuc());
		d.setEmail(df.getEmail());
		d.setDireccion(df.getDireccion());
		d.setTelefono(df.getTelefono());
		d.setNombre(df.getNombre());

		if (StringUtils.isEmpty(df.getId())) {
			clienteDAO.insert(d);
		} else {
			d.setId(df.getId());
			clienteDAO.update(d);
		}
	}

	public ClienteForm getClientePorId(String id) {
		ClienteForm df = new ClienteForm();
		Cliente d = clienteDAO.findByPK(Cliente.class, id);

		if (d != null) {
			df.setId(d.getId().toString());
			df.setNombre(d.getNombre());
			df.setApePat(d.getApePat());
			df.setApeMat(d.getApeMat());
			df.setDni(d.getDni());
			df.setRuc(d.getRuc());
			df.setEmail(d.getEmail());
			df.setDireccion(d.getDireccion());
			df.setTelefono(d.getTelefono());
			
		}

		return df;
	}
	
	@Transactional(readOnly = false)
	public void removeCliente(String id) {
		Cliente d = clienteDAO.findByPK(Cliente.class, id);

		if (d != null) {
			clienteDAO.remove(d);
		} else {
			System.out.println("no hay datos" + d);
			
		}
	}
	
	public ClienteForm getClientePorNombre(String nombre, String valor) {
		ClienteForm df = new ClienteForm();
		Cliente d = clienteDAO.findByColumn(Cliente.class, nombre, valor);

		if (d != null) {
			df.setId(d.getId().toString());
			df.setNombre(d.getNombre());
			df.setApePat(d.getApePat());
			df.setApeMat(d.getApeMat());
			df.setDni(d.getDni());
			df.setRuc(d.getRuc());
			df.setEmail(d.getEmail());
			df.setDireccion(d.getDireccion());
			df.setTelefono(d.getTelefono());
			
		}

		return df;
	}

	/**
	 * @param typeClass
	 * @param nombre
	 * @param valorRestriccion
	 * @return
	 * @see edu.upeu.school.dao.ClienteDAO#getAllRestrictionEQ(java.lang.Class, java.lang.String, java.lang.String)
	 */
	public List<ClienteForm> buscarPor( String valor) {
		
//		String nombre="nombre";
		List<ClienteForm> lf = new ArrayList<ClienteForm>();

		List<Cliente> lista = clienteDAO.buscarPor(valor);

		for (Cliente d : lista) {
			ClienteForm df = new ClienteForm();
			df.setId(d.getId());
			df.setNombre(d.getNombre());
			df.setApePat(d.getApePat());
			df.setApeMat(d.getApeMat());
			df.setDni(d.getDni());
			df.setRuc(d.getRuc());
			df.setEmail(d.getEmail());
			df.setDireccion(d.getDireccion());
			df.setTelefono(d.getTelefono());

			lf.add(df);
		}

		return lf;
		
	}

	/**
	 * @param typeClass
	 * @param nombre
	 * @param valorRestriccion
	 * @return
	 * @see edu.upeu.school.dao.ClienteDAO#getAllRestriccionNE(java.lang.Class, java.lang.String, java.lang.String)
	 */
	public List<ClienteForm> getAllRestriccionNE( String valorRestriccion) {
		
	//	Class typeClass = Class<Cliente> typeClass;
		String nombre="nombre";
		List<ClienteForm> lf = new ArrayList<ClienteForm>();

		List<Cliente> lista = clienteDAO.getAllRestrictionNE(Cliente.class, nombre, valorRestriccion);

		for (Cliente d : lista) {
			ClienteForm df = new ClienteForm();
			df.setId(d.getId());
			df.setNombre(d.getNombre());
			df.setApePat(d.getApePat());
			df.setApeMat(d.getApeMat());
			df.setDni(d.getDni());
			df.setRuc(d.getRuc());
			df.setEmail(d.getEmail());
			df.setDireccion(d.getDireccion());
			df.setTelefono(d.getTelefono());

			lf.add(df);
		}

		return lf;
		
//		return clienteDAO.getAllRestriccionNE(typeClass, nombre,
//				valorRestriccion);
	}


	
	
}
