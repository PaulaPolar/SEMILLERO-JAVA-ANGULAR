package com.heinsohn.semillero.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {

	@Id
	private int cedula;
	
	private String nombre;
	
	private String login;
	
	private String correo;

	private String password;
	
	private String estado;
	
	public Usuarios(int cedula, String nombre, String login, String correo,String password, String estado) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.login = login;
		this.correo =correo;
		this.password = password;
		this.estado = estado;
	}

	public Usuarios() {
		// TODO Auto-generated constructor stub
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
