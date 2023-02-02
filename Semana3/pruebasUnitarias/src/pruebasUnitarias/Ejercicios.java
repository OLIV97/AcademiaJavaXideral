package pruebasUnitarias;

public class Ejercicios {

	// Ejercicio de palabras inversas
	public static String palabrasInversas(final String original) {
		String result = "";
		String[] sin_espa = original.split(" ");

		if (sin_espa.length == 0)
			return original;

		for (int i = 0; i < sin_espa.length; i++) {
			StringBuilder sb = new StringBuilder(sin_espa[i]);
			result += sb.reverse().toString() + " ";
		}

		return result.trim();
	}

	// ejercicios de raiz digital
	public static int raiz_digital(int n) {
		String[] number = (n + "").split("");
		if (number.length == 1)
			return n;
		n = 0;
		for (int i = 0; i < number.length; i++) {
			n += Integer.parseInt(number[i]);
		}
		return raiz_digital(n);
	}

}
