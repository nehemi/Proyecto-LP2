package edu.upeu.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lowagie.text.pdf.PRAcroForm;

import edu.upeu.school.dao.ProductoDAO;
import edu.upeu.school.domain.Cliente;
import edu.upeu.school.domain.Producto;
import edu.upeu.school.service.ProductoService;
import edu.upeu.school.web.form.ClienteForm;
import edu.upeu.school.web.form.ProductoForm;

@Service
@Transactional(readOnly = true)
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDAO productoDAO;

	public List<ProductoForm> listarProductos() {

		List<ProductoForm> l = new ArrayList<ProductoForm>();

		List<Producto> lista = productoDAO.getAll(Producto.class);

		for (Producto p : lista) {
			ProductoForm pf = new ProductoForm();
			pf.setId_producto(p.getId_producto().toString());
			pf.setCodigo(p.getCodigo());
			pf.setDescripcion(p.getDescripcion());
			pf.setPrecio(p.getPrecio());
			pf.setStock(p.getStock());

			l.add(pf);
		}

		return l;
	}

	@Transactional(readOnly = false)
	public void guardarProducto(ProductoForm af) {
		Producto producto = new Producto();
		producto.setDescripcion(af.getDescripcion());
		producto.setPrecio(af.getPrecio());
		producto.setStock(af.getStock());
		producto.setCodigo(af.getCodigo());

		if (StringUtils.isEmpty(af.getId_producto())) {
			productoDAO.insert(producto);
		} else {
			producto.setId_producto(af.getId_producto());
			productoDAO.update(producto);
		}

	}

	public ProductoForm getProductoPorId(String id) {
		ProductoForm a = new ProductoForm();
		Producto producto = productoDAO.findByPK(Producto.class, id);

		if (producto != null) {
			a.setId_producto(producto.getId_producto().toString());
			a.setCodigo(producto.getCodigo());
			a.setDescripcion(producto.getDescripcion());
			a.setPrecio(producto.getPrecio());
			a.setStock(producto.getStock());
		}

		return a;
	}
	
	@Transactional(readOnly = false)
	public void removeProd(String id) {
		Producto d = productoDAO.findByPK(Producto.class, id);

		if (d != null) {
			productoDAO.removeP(d);
		} else {
			System.out.println("no hay datos" + d);
			
		}
	}
	
public List<ProductoForm> buscarPor( String valor) {
		
//		String nombre="nombre";
		List<ProductoForm> lf = new ArrayList<ProductoForm>();

		List<Producto> lista = productoDAO.buscarPor(valor);

		for (Producto d : lista) {
			ProductoForm df = new ProductoForm();
			df.setId_producto(d.getId_producto());
			df.setCodigo(d.getCodigo());
			df.setDescripcion(d.getDescripcion());
			df.setPrecio(d.getPrecio());
			df.setStock(d.getStock());
			
			

			lf.add(df);
		}

		return lf;
		
	}


}
