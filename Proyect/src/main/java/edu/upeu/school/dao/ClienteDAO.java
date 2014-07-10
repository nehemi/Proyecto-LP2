package edu.upeu.school.dao;

import java.util.List;

import edu.upeu.school.domain.Cliente;

public interface ClienteDAO extends GenericDao<Cliente, String> {
	// void delete(final Cliente cliente);
	void remove(Cliente object);

	Cliente findByColumn(Class<Cliente> typeClass, String nombre, String valor);

	List<Cliente> buscarPor(String valor);
	// List<Cliente> getAllRestriccionNE(Class<Cliente> typeClass,
	// String nombre, String valorRestriccion);

}
