package observerpersonal;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	
	List<Observer> listaObservers = new ArrayList<>();
	
	void suscribir(Observer o) {
		listaObservers.add(o);
	}

	void desuscribir(Observer o) {
		listaObservers.remove(o);
	}

	void notificar() {
		for(Observer o:listaObservers)
			o.entrada();
	}

}
