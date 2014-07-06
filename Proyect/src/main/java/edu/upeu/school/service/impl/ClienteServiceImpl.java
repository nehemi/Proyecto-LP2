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
	
//	public void removeCliente(Integer id) {
//		 Cliente cliente = (Cliente) getSession().getCurrentSession().load(
//		 Cliente.class, id);
//		 if (null != cliente) {
//		 getSession.getCurrentSession().delete(cliente);
//		 }
//	}
}
