package edu.upeu.school.web.form;

import java.util.List;

public class ProductoForm {

	private String id;
	private String codigo;
	private String descripcion;
	private Double precio;
	private Integer stock;
	private List<VentaForm> ventas;

	public List<VentaForm> getVentas() {
		return ventas;
	}

	public void setVentas(List<VentaForm> ventas) {
		this.ventas = ventas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}



}
