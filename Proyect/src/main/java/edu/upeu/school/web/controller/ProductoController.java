package edu.upeu.school.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.upeu.school.service.ProductoService;
import edu.upeu.school.web.form.ProductoForm;

@Controller
@RequestMapping(value = "/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listarProductos(Model model) {
		List<ProductoForm> lista = productoService.listarProductos();
		model.addAttribute("lp", lista);
		return "producto/main";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String mostrarFormularioNuevoProducto(Model model) {
		ProductoForm producto = new ProductoForm();
		model.addAttribute("producto", producto);
		return "producto/formulario";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	public String guardarProductoNuevo(@ModelAttribute ProductoForm af,
			BindingResult result, Model model) {
		productoService.guardarProducto(af);
		return "redirect:/productos/";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String mostrarFormularioProducto(@PathVariable String id, Model model) {
		ProductoForm producto = productoService.getProductoPorId(id);
		model.addAttribute("producto", producto);

		return "producto/formulario";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String actualizarProducto(@PathVariable String id,
			@ModelAttribute ProductoForm af, Model model) {
		productoService.guardarProducto(af);

		return "redirect:/productos/";
	}

}
