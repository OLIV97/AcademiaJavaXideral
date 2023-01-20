package Singletons;
import java.util.ArrayList;
import java.util.List;

public class Checadora {

	private static Checadora checadora;

	private List<String> lista;
	
	private Checadora() {
		lista = new ArrayList<>();
	}
	
	//Metodo para instanciar el objeto
    public static Checadora getInstancia() {
    	
        if (checadora == null) {
        	checadora = new Checadora();
        }
        return checadora;
    }
    
  //Metodo para checar la hora de entrada y agregarla a la lista de entradas
    public void Checkperson(String name) {
    	
    	//Se instancia el reljo de la checadora
    	RelojChecadora  h= RelojChecadora.getInstancia();
    	
    	lista.add("La persona: "+name+" checo su entrada el dia y hora: "+h.getCheck());
    	
    }
    
  //Metodo para desplegar la lista de entradas
    public void ShowList() {
        for(String cadena :lista) {
            System.out.println(cadena);
          }
    }
}
