package Singletons;

public class Principal {

	public static void main(String[] args) {


		Checadora  h= Checadora.getInstancia();
		
		Persona p1 = new Persona("Susanito perez", "Jefazo");
		Persona p2 = new Persona("sotanita del socorro", "Secretaria");
		Persona p3 = new Persona("Menganito chin", "Guardia");
		Persona p4 = new Persona("Enrique segoviano", "Director");
		
		h.Checkperson(p1.getNombre());
		h.Checkperson(p2.getNombre());
		h.Checkperson(p3.getNombre());
		h.Checkperson(p4.getNombre());

		h.ShowList();

	}

}
