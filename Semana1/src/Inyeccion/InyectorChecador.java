package Inyeccion;

import java.util.Calendar;

public class InyectorChecador {

	//Metodo para inyectar al personal su hora de entrada o salida
	static void inyectarEntradaSalida(String tipo,PersonalInterface personal) {
		Calendar date = Calendar.getInstance();
		if (tipo.equals("entrada")) {
			personal.setEntrada(date.getTime());
		}else {
			personal.setSalida(date.getTime());
		}
	}
}
