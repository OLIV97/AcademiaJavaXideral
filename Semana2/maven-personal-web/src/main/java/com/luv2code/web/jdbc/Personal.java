package com.luv2code.web.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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


	
}
