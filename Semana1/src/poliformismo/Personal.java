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

	void setEntrada(Date entrada) {
		 this.horaEntrada = entrada;
	 }
	
	 void setSalida(Date salida) {
		 this.horaSalida = salida;
	 }
	
	 Date getEntrada() {
		 return horaEntrada;
	 }
		
	 Date getSalida() {
		return horaSalida;
	 }
	 public String getPuesto() {
		return puesto;
	}


	
}
