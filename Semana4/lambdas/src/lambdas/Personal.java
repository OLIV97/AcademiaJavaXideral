package lambdas;

import java.util.Date;

public class Personal{

	private String nombre;
	private String puesto;
	private String horaEntrada;
	private String horaSalida;
	private String transporte;
	
	 public Personal() {
		 
	 }
	 public Personal(String nombre, String puesto, String transporte) {
	
		this.nombre = nombre;
		this.puesto = puesto;
		this.transporte = transporte;
	}
	

 
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getTransporte() {
		return transporte;
	}
	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}
	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String workinIn() {	
		return this.nombre+" esta trabajando en el area/departanmento de "+  this.puesto;
	}

	public String arriving() {
		return   this.nombre+" llego hoy en " +  this.transporte;
	}
	
}
