package edu.upeu.school.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.upeu.school.service.ClienteService;
import edu.upeu.school.web.form.ClienteForm;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarListaClientes(Model model) {

		List<ClienteForm> lista = clienteService.getListaClientes();
		model.addAttribute("lp", lista);

		return "cliente/main";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String mostrarFormularioClienteNuevo() {
		return "cliente/formulario";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	public String guardarClienteNuevo(@ModelAttribute ClienteForm df) {

		clienteService.guardarCliente(df);

		return "redirect:/clientes/";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String mostrarFormularioCliente(@PathVariable String id, Model model) {

		ClienteForm df = clienteService.getClientePorId(id);
		model.addAttribute("cliente", df);

		return "cliente/formulario";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String actualizarCliente(@PathVariable String id,
			@ModelAttribute ClienteForm df, Model model) {

		clienteService.guardarCliente(df);

		return "redirect:/clientes/";
	}

}
