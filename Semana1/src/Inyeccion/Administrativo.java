package Inyeccion;

import java.util.Date;

public class Administrativo extends Personal {

	public Administrativo(String nombre, String puesto, String transporte) {
		super(nombre, puesto, transporte);
	}
	
	@Override
	public String workinIn() {	
		return nombre+" esta trabajando en el area/departanmento de "+ puesto;
	}

	@Override
	public String arriving() {
		return  nombre+" llego hoy en " + transporte;
	}

	@Override
	public void setEntrada(Date entrada) {
		 this.horaEntrada = entrada;
	 }
	
	@Override
	 public void setSalida(Date salida) {
		 this.horaSalida = salida;
	 }
	
	@Override
	public Date getEntrada() {
		 return horaEntrada;
	 }
	@Override
	public  Date getSalida() {
		return horaSalida;
	 }
}
