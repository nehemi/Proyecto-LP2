package edu.upeu.school.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "PRODUCTO")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "genId")
    @GenericGenerator(name = "genId", strategy = "edu.upeu.school.util.GeneradorIDRandom")
	@Column(name = "ID_PRODUCTO")
	private String id_producto;
	@Column(name = "codigo")
	private String codigo;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "precio")
	private Double precio;
	@Column(name = "stock")
	private Integer stock;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Venta.class)
//	private List<Venta> ventaProd;
//
//	public List<Venta> getVentaProd() {
//		return ventaProd;
//	}
//
//	public void setVentaProd(List<Venta> ventaProd) {
//		this.ventaProd = ventaProd;
//	}
//
//	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_producto == null) ? 0 : id_producto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (id_producto == null) {
			if (other.id_producto != null)
				return false;
		} else if (!id_producto.equals(other.id_producto))
			return false;
		return true;
	}

}
