package edu.upeu.school.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.upeu.school.service.VentaService;
import edu.upeu.school.web.form.VentaForm;

@Controller
@RequestMapping (value = "/ventas" )
public class VentaController {
	
	@Autowired
	private VentaService ventaService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarListaVenta(Model model) {

		List<VentaForm> lista = ventaService.getListaVenta();
		model.addAttribute("lp", lista);

		return "venta/main";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String mostrarFormularioVentaNuevo() {
		return "venta/formulario";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	public String guardarVentaNuevo(@ModelAttribute VentaForm df) {

		ventaService.guardarVenta(df);

		return "redirect:/ventas/";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String mostrarFormularioVenta(@PathVariable String id, Model model) {

		VentaForm df = ventaService.getVentaPorId(id);
		model.addAttribute("venta", df);

		return "venta/formulario";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String actualizarVenta(@PathVariable String id,
			@ModelAttribute VentaForm df, Model model) {

		ventaService.guardarVenta(df);

		return "redirect:/ventas/";
	}


}
