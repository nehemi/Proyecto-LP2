package edu.upeu.school.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	private String id;
	@Column(name = "codigo")
	private String codigo;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "precio")
	private Double precio;
	@Column(name = "stock")
	private Integer stock;

//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "producto_venta", joinColumns = { @JoinColumn(name = "ID_PRODUCTO", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "ID_VENTA", nullable = false, updatable = false) })
//	private Set<Venta> ventas;
//
//	public Set<Venta> getVentas() {
//		return ventas;
//	}
//
//	public void setVentas(Set<Venta> ventas) {
//		this.ventas = ventas;
//	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
