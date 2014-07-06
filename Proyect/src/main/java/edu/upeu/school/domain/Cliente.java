package edu.upeu.school.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "genId")
	@GenericGenerator(name = "genId", strategy = "edu.upeu.school.util.GeneradorIDRandom")
	@Column(name = "id")
	private String id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apePat")
	private String apePat;
	@Column(name = "apeMat")
	private String apeMat;
	@Column(name = "dni")
	private Integer dni;
	@Column(name = "ruc")
	private Integer ruc;
	@Column(name = "email")
	private String email;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "telefono")
	private Integer telefono;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApePat() {
		return apePat;
	}
	public void setApePat(String apePat) {
		this.apePat = apePat;
	}
	public String getApeMat() {
		return apeMat;
	}
	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public Integer getRuc() {
		return ruc;
	}
	public void setRuc(Integer ruc) {
		this.ruc = ruc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
}
