package observerpersonal;

import java.util.Calendar;
import java.util.Date;



public class Administrativo extends Observer {

	Calendar date = Calendar.getInstance();
	String nombre;
	Date horaEntrada;
	
	public Administrativo(String nombre,Subject sb) {
		super(sb);
		this.nombre = nombre;		
		this.horaEntrada = date.getTime() ;
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	void entrada() {
	System.out.println("El administrativo "+nombre+" entro a la hora y dia: "+ horaEntrada );
	}
	
}
