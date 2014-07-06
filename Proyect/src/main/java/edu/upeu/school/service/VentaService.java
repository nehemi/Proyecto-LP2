package edu.upeu.school.service;

import java.util.List;

import edu.upeu.school.web.form.VentaForm;

public interface VentaService {
	
	List<VentaForm> getListaVenta();

	void guardarVenta(VentaForm df);

	VentaForm getVentaPorId(String id);

}
