package Singletons;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class RelojChecadora extends Thread  {
    private static RelojChecadora relojchecadora;
 
    private DateTimeFormatter dtf;


    private RelojChecadora() {
    	//dd/MM/uuuu HH:mm:ss
        dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
     
    }

    //Metodo para obtener la hora de entrada
    public String getCheck() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	return dtf.format(LocalDateTime.now());
    }
    
	//Metodo para instanciar el objeto
    public static RelojChecadora getInstancia() {
    	
        if (relojchecadora == null) {
        	relojchecadora = new RelojChecadora();
        }
        return relojchecadora;
    }


}
