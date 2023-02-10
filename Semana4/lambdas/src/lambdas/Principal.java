package lambdas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;



public class Principal {

	public static void main(String[] args) {
		
		List<Personal> personal = new ArrayList<Personal>();
		
		personal.add(new Personal("Enrique segoviano", "Director", "Auto"));
		personal.add(new Personal("sotanita del socorro", "Taller de base de datos", "Autobus"));
		personal.add(new Personal("Susanito perez", "Mantenimiento", "Taxi"));
		personal.add(new Personal("Menganito chin", "Camaras", "Auto"));
		
	      DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		//set entrada o salida
	      BiFunction<Personal,String,Personal> check = (person,c)->{ 
	        try {
	        		Calendar obj = Calendar.getInstance();
	                Thread.sleep(1000);
	                if(c.equals("ENTRADA")) {
	                	 person.setHoraEntrada(formatter.format(obj.getTime()));  
	                }{
	                	 person.setHoraSalida(formatter.format(obj.getTime()));  
	                }
	               
	        }
	        catch (Exception e) {
	            System.out.println(e);
	        }
			return person;
		};
		//consumer para imprimir
		BiConsumer<Personal, String> print = (person,c) ->{
			System.out.println("El personal "+person.getNombre()+ " checo su "+ c.toLowerCase() + "a la hora "+ (c.equals("ENTRADA")?person.getHoraEntrada():person.getHoraSalida()));
		};
		
		personal.replaceAll(x->check.apply(x,"ENTRADA"));
		
		personal.forEach(x->print.accept(x, "ENTRADA"));
		
		System.out.println("-------------------------------------------");
		
		personal.replaceAll(x->check.apply(x,"SALIDA"));
		
		personal.forEach(x->print.accept(x, "SALIDA"));
		
		
//		Supplier<Integer> sup3 = () -> Integer.valueOf(9);
		
	}
}
