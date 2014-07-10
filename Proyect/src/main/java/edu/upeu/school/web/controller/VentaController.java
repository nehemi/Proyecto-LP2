package edu.upeu.school.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.upeu.school.dao.ClienteDAO;
import edu.upeu.school.service.ClienteService;
import edu.upeu.school.service.VentaService;
import edu.upeu.school.web.form.ClienteForm;
import edu.upeu.school.web.form.VentaForm;

@Controller
@RequestMapping (value = "/ventas" )
public class VentaController {
	
	
	
	@Autowired
	private VentaService ventaService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ClienteDAO clienteDAO;

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
	
	
	
	@RequestMapping(value = "/aut", method = RequestMethod.GET)
	public JSONArray clienteObjj(String df) {
//		serv= new AlumnoServicioImpt(); 
		
		HttpServletResponse response;
		HttpServletRequest r = null;
		List<ClienteForm> lista;
        String dato=(String)r.getParameter("q"); 
                                            
        lista=clienteService.buscarPor(dato);
        JSONArray jsonMenuLis = new JSONArray();
        JSONObject arrayObj;
        int i=0;
        if(lista!=null) { for (ClienteForm client : lista) {              
            arrayObj = new JSONObject();
            arrayObj.put("label",client.getNombre());
            arrayObj.put("valor",client.getApePat());
            arrayObj.put("id",client.getId());
            arrayObj.put("direccion",client.getDireccion());
            arrayObj.put("dni",client.getDni());
            arrayObj.put("ruc",client.getRuc());
            arrayObj.put("email",client.getEmail());
            arrayObj.put("telef",client.getTelefono());
            jsonMenuLis.add(i,arrayObj);
            i=i+1;
        }}else{
            arrayObj = new JSONObject();
            arrayObj.put("label","No Existe");
            arrayObj.put("valor","");
            arrayObj.put("id","");
            arrayObj.put("direccion","");
            arrayObj.put("dni","");
            arrayObj.put("ruc","");
            arrayObj.put("email","");
            arrayObj.put("telef","");
            jsonMenuLis.add(i,arrayObj);                
        }
//        out.print(jsonMenuLis);
		return jsonMenuLis;

}    
}
