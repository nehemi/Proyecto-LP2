package edu.upeu.school.web.form;

public class ProductoForm {

	private String id_producto;
	private String codigo;
	private String descripcion;
	private Double precio;
	private Integer stock;
//	private List<VentaForm> ventas;

//	public List<VentaForm> getVentas() {
//		return ventas;
//	}
//
//	public void setVentas(List<VentaForm> ventas) {
//		this.ventas = ventas;
//	}

	
	public String getId_producto() {
		return id_producto;
	}

	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
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
