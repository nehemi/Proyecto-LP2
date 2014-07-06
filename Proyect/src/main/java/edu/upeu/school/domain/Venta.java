package edu.upeu.school.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "VENTA")
public class Venta implements Serializable {

	private static final long serialVersionUID = -2701724388095813764L;
	@Id
	@GeneratedValue(generator = "genId")
	@GenericGenerator(name = "genId", strategy = "edu.upeu.school.util.GeneradorIDRandom")
	@Column(name = "ID_VENTA")
	private String id;
	@Column(name = "FECHA")
	private String fecha;
	@Column(name = "DETALLE")
	private String detalle;
	@Column(name = "CANTIDAD")
	private String cantidad;

//	@ManyToOne(targetEntity=Class<Venta>, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "producto_venta", joinColumns = { @JoinColumn(name = "ID_PRODUCTO", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "ID_VENTA", nullable = false, updatable = false) })
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Cliente cliente;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ventaDetalle.class)
	private List<ventaDetalle> detalles;
	
//	private Set<Producto> productos;
//
//	public Set<Producto> getProductos() {
//		return productos;
//	}
//
//	public void setProductos(Set<Producto> productos) {
//		this.productos = productos;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ventaDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<ventaDetalle> detalles) {
		this.detalles = detalles;
	}
	
}
