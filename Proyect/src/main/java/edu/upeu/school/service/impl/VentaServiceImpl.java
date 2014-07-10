package edu.upeu.school.service.impl;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.upeu.school.dao.ClienteDAO;
import edu.upeu.school.dao.VentaDAO;
import edu.upeu.school.domain.Venta;
import edu.upeu.school.service.VentaService;
import edu.upeu.school.web.form.VentaForm;

@Service
@Transactional(readOnly = true)
public class VentaServiceImpl implements VentaService {
	
	
	

		@Autowired
		private VentaDAO ventaDAO;
		@Autowired
		private ClienteDAO clienteDAO;

		public List<VentaForm> getListaVenta() {

			List<VentaForm> lf = new ArrayList<VentaForm>();

			List<Venta> lista = ventaDAO.getAll(Venta.class);

			for (Venta d : lista) {
				VentaForm df = new VentaForm();
				df.setId_venta(d.getId_venta());
				df.setFecha(d.getFecha());
				df.setDetalle(d.getDetalle());
				df.setCantidad(d.getCantidad());
				df.setId_producto(d.getId_producto());
				df.setIdCliente(d.getId());
				
				
				
				
				
				lf.add(df);
			}

			return lf;
		}

		@Transactional(readOnly = false)
		public void guardarVenta(VentaForm df) {
			Date fech = new Date();
			Venta d = new Venta();
			d.setFecha(String.valueOf(fech.getDate()));
			d.setDetalle(df.getDetalle());
			d.setCantidad(df.getCantidad());
//			d.setCliente(clienteDAO.findByPK(Cliente.class, df.getIdCliente()));
			if (StringUtils.isEmpty(df.getId_venta())) {
				ventaDAO.insert(d);
			} 
		}

		public VentaForm getVentaPorId(String id) {
			VentaForm df = new VentaForm();
			Venta d = ventaDAO.findByPK(Venta.class, id);

			if (d != null) {
				df.setId_venta(d.getId_venta().toString());
				df.setFecha(d.getFecha());
				df.setDetalle(d.getDetalle());
				df.setCantidad(d.getCantidad());
				
			}

			return df;
		}

	
		
}
