package Inyeccion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Principal extends Thread {

	public static void main(String[] args) {
		
		List<PersonalInterface> personal = new ArrayList();
		
		personal.add(new Administrativo("Enrique segoviano", "Director", "Auto"));
		personal.add(new Docente("sotanita del socorro", "Taller de base de datos", "Autobus"));
		personal.add(new Intendencia("Susanito perez", "Mantenimiento", "Taxi"));
		personal.add(new Seguridad("Menganito chin", "Camaras", "Auto"));

		
			
        for(PersonalInterface p1 :personal) {
        	try {
        		//simular el tiempo en que esta en frente de la checadora
	        	sleep(2000);
	        	
	        	//En si la hora de entrada y salida no la da el Personal si no la maquina para checar
	    		InyectorChecador.inyectarEntradaSalida("entrada", p1);

	    		System.out.println("Hora de entrada: "+p1.getEntrada());
	    		System.out.println(p1.workinIn());
	    		System.out.println(p1.arriving());

	    		//simula el timepo de trabajo para salir        	
	        	sleep(2000);
	        	
	        	//En si la hora de entrada y salida no la da el Personal si no la maquina para checar
	    		InyectorChecador.inyectarEntradaSalida("salida", p1);
	    		System.out.println("Hora de salida: "+p1.getSalida());
	    		System.out.println("-----------------------------");
	    		
        	} catch (InterruptedException e) {
    			e.printStackTrace();
    			}
          }
		
	}

}
//try {
//    sleep(3000);
//} catch (InterruptedException e) {
//    e.printStackTrace();
//}