package com.project.springboot.personalrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="lista_asistencia")
public class Personal {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombres")
	private String nombres;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="hora_entrada")
	private String horaentrada;
	
	@Column(name="hora_salida")
	private String horasalida;
		
	public Personal(String nombres, String apellidos) {
		this.nombres = nombres;
		this.apellidos = apellidos;
	}
}
