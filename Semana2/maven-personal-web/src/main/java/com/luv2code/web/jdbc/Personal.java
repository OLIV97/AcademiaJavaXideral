package com.luv2code.web.jdbc;

public class Personal {

	private int id;
	private String nombres;
	private String apellidos;
	private String horaentrada;
	private String horasalida;
	
	public Personal(String nombres, String apellidos) {
		this.nombres = nombres;
		this.apellidos = apellidos;
	}

	public Personal(int id, String nombres, String apellidos, String horaentrada,String horasalida) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.horaentrada = horaentrada;
		this.horasalida = horasalida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getHoraentrada() {
		return horaentrada;
	}

	public void setHoraentrada(String horaentrada) {
		this.horaentrada = horaentrada;
	}

	public String getHorasalida() {
		return horasalida;
	}

	public void setHorasalida(String horasalida) {
		this.horasalida = horasalida;
	}

	@Override
	public String toString() {
		return "Personal [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", horaentrada="
				+ horaentrada + ", horasalida=" + horasalida + "]";
	}

	
}
