package Singletons;
import java.util.ArrayList;
import java.util.List;

public class Checadora {

	private static Checadora checadora;

	private List<String> lista;
	
	private Checadora() {
		lista = new ArrayList<>();
	}
	
	
    public static Checadora getInstancia() {
    	
        if (checadora == null) {
        	checadora = new Checadora();
        }
        return checadora;
    }
    
    public void Checkperson(String name) {
    	
    	RelojChecadora  h= RelojChecadora.getInstancia();
    	
    	lista.add("La persona: "+name+" checo su entrada el dia y hora: "+h.getCheck());
    	
    }
    
    public void ShowList() {
        for(String cadena :lista) {
            System.out.println(cadena);
          }
    }
}
