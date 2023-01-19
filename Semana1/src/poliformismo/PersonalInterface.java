package poliformismo;

import java.util.Date;

public interface PersonalInterface {

	String workinIn();
	
	String arriving();

	void setEntrada(Date time);

	Date getEntrada();
	
	void setSalida(Date time);

	Date getSalida();
	
}
