package edu.upeu.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.upeu.school.dao.ProductoDAO;
import edu.upeu.school.domain.Producto;
import edu.upeu.school.service.ProductoService;
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
			pf.setId(p.getId().toString());
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

		if (StringUtils.isEmpty(af.getId())) {
			productoDAO.insert(producto);
		} else {
			producto.setId(af.getId());
			productoDAO.update(producto);
		}

	}

	public ProductoForm getProductoPorId(String id) {
		ProductoForm a = new ProductoForm();
		Producto producto = productoDAO.findByPK(Producto.class, id);

		if (producto != null) {
			a.setId(producto.getId().toString());
			a.setCodigo(producto.getCodigo());
			a.setDescripcion(producto.getDescripcion());
			a.setPrecio(producto.getPrecio());
			a.setStock(producto.getStock());
		}

		return a;
	}

}
