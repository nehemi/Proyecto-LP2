package edu.upeu.school.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import edu.upeu.school.web.form.ProductoForm;
import edu.upeu.school.web.form.VentaForm;


@Entity
@Table(name = "VENTA")
public class Venta implements Serializable {

	private static final long serialVersionUID = -2701724388095813764L;
	@Id
	@GeneratedValue(generator = "genId")
	@GenericGenerator(name = "genId", strategy = "edu.upeu.school.util.GeneradorIDRandom")
	@Column(name = "ID_VENTA")
	private String id_venta;
	@Column(name = "FECHA")
	private String fecha;
	@Column(name = "DETALLE")
	private String detalle;
	@Column(name = "CANTIDAD")
	private String cantidad;

//	@ManyToOne(targetEntity=Class<Venta>, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "producto_venta", joinColumns = { @JoinColumn(name = "ID_PRODUCTO", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "ID_VENTA", nullable = false, updatable = false) })

///////////////////////////////////////////////////////////////////////	
//	@ManyToOne( optional = false)
//	@JoinColumns(@JoinColumn(name = "id_producto", referencedColumnName = "id_producto"))
//	@JoinColumn(name = "id", referencedColumnName = "id")
//	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	
	private Producto id_producto;
	private Cliente id;

	
	
	public Producto getId_producto() {
		return id_producto;
	}

	public void setId_producto(Producto id_producto) {
		this.id_producto = id_producto;
	}

	public String getId_venta() {
		return id_venta;
	}

	public void setId_venta(String id_venta) {
		this.id_venta = id_venta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public Cliente getId() {
		return id;
	}

	public void setId(Cliente id) {
		this.id = id;
	}
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ventaDetalle.class)
//	private List<ventaDetalle> detalles;
//////////////////////////////////////////////////////////////////////////////	

	
}
