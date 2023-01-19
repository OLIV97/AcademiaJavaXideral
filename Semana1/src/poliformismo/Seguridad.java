package poliformismo;

public class Seguridad extends Personal {

	public Seguridad(String nombre, String puesto, String transporte) {
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

}
