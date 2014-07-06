package edu.upeu.school.service;

import java.util.List;

import edu.upeu.school.web.form.ClienteForm;

public interface ClienteService {

	List<ClienteForm> getListaClientes();

	void guardarCliente(ClienteForm df);

	ClienteForm getClientePorId(String id);

}
