package observerpersonal;

public abstract class Observer {
	
	Subject sb;
	
	Observer(Subject sb){
		this.sb = sb;
		sb.suscribir(this);
	}
	
	abstract void entrada();
	
}
