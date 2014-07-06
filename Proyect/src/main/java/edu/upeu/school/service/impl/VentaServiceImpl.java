package edu.upeu.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.upeu.school.dao.VentaDAO;
import edu.upeu.school.domain.Venta;
import edu.upeu.school.service.VentaService;
import edu.upeu.school.web.form.VentaForm;

@Service
@Transactional(readOnly = true)
public class VentaServiceImpl implements VentaService {
	
	
	

		@Autowired
		private VentaDAO ventaDAO;

		public List<VentaForm> getListaVenta() {

			List<VentaForm> lf = new ArrayList<VentaForm>();

			List<Venta> lista = ventaDAO.getAll(Venta.class);

			for (Venta d : lista) {
				VentaForm df = new VentaForm();
				df.setId(d.getId());
				df.setFecha(d.getFecha());
				df.setDetalle(d.getDetalle());
				df.setCantidad(d.getCantidad());
				
				
				lf.add(df);
			}

			return lf;
		}

		@Transactional(readOnly = false)
		public void guardarVenta(VentaForm df) {
			Venta d = new Venta();
			d.setFecha(df.getFecha());
			d.setDetalle(df.getDetalle());
			d.setCantidad(df.getCantidad());
			
			if (StringUtils.isEmpty(df.getId())) {
				ventaDAO.insert(d);
			} else {
				d.setId(df.getId());
				ventaDAO.update(d);
			}
		}

		public VentaForm getVentaPorId(String id) {
			VentaForm df = new VentaForm();
			Venta d = ventaDAO.findByPK(Venta.class, id);

			if (d != null) {
				df.setId(d.getId().toString());
				df.setFecha(d.getFecha());
				df.setDetalle(d.getDetalle());
				df.setCantidad(d.getCantidad());
				
			}

			return df;
		}

}
