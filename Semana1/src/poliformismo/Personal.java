package poliformismo;

import java.util.Date;

public abstract class Personal implements PersonalInterface  {

	String nombre;
	String puesto;
	Date horaEntrada;
	Date horaSalida;
	String transporte;
	
	 public Personal(String nombre, String puesto, String transporte) {
		super();
		this.nombre = nombre;
		this.puesto = puesto;
		this.transporte = transporte;
	}
	
	 public String getPuesto() {
		return puesto;
	}


	
}
