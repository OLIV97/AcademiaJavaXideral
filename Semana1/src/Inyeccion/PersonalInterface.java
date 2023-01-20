package Inyeccion;

import java.util.Date;

public interface PersonalInterface {

	//metodo para saber en que area trabaja
	String workinIn();
	
	//metodo para saber en
	String arriving();

	//set hora entrada
	void setEntrada(Date time);
	
	//get hora entrada
	Date getEntrada();
	
	//set hora salida
	void setSalida(Date time);

	//get hora salida
	Date getSalida();
	
	
}
