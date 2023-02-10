package observerpersonal;

public class Principal {

	public static void main(String[] args) {
		try {
			Checadora checadora = new Checadora();

			new Administrativo("susanita", checadora);

			checadora.showList();
			Thread.sleep(2000);
			System.out.println("------------------------------------");


			new Docente("patrobas", checadora);

			checadora.showList();
			Thread.sleep(2000);
			
			
			System.out.println("------------------------------------");
			
			new Intendencia("menganito", checadora);

			checadora.showList();
			
			Thread.sleep(2000);
			
			
			System.out.println("------------------------------------");
			
			new Seguridad("penganito", checadora);

			checadora.showList();
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
