/**
 * Representa una cuenta bancaria sencilla para gestionar saldo.
 * Permite realizar operaciones básicas como ingresos y retiradas.
 *
 * @author Ivan
 * @version 1.0
 */
public class CCuenta {

	/** Saldo actual de la cuenta. */
	private double dSaldo = 0;

	/**
	 * Ingresa una cantidad de dinero en la cuenta.
	 * El ingreso solo es efectivo si la cantidad es positiva.
	 *
	 * @param cantidad La suma de dinero a depositar.
	 * @return 0 si el ingreso fue exitoso, 1 si la cantidad era negativa.
	 */
	public int ingresar(double cantidad) {
		int iCodErr;
		if (cantidad < 0) {
			System.out.println("No se puede ingresar una cantidad negativa");
			iCodErr = 1;
		} else {
			// Depuracion. Punto de parada. Solo en el 3 ingreso
			dSaldo = dSaldo + cantidad;
			iCodErr = 0;
		}
		// Depuracion. Punto de parada cuando la cantidad es menor de 0
		return iCodErr;
	}

	/**
	 * Retira una cantidad de dinero de la cuenta.
	 * Verifica que la cantidad sea positiva y que exista saldo suficiente.
	 *
	 * @param cantidad La suma de dinero a extraer.
	 */
	public void retirar(double cantidad) {
		if (cantidad <= 0) {
			System.out.println("No se puede retirar una cantidad negativa");
		} else if (dSaldo < cantidad) {
			System.out.println("No se hay suficiente saldo");
		} else {
			dSaldo = dSaldo - cantidad;
		}
	}

	/**
	 * Método principal para probar el funcionamiento de la clase.
	 * Realiza una serie de depósitos y retiradas de prueba.
	 *
	 * @param args Argumentos de la línea de comandos (no utilizados).
	 */
	public static void main(String[] args) {
		// Depuracion. Se detiene siempre
		CCuenta miCuenta = new CCuenta();
		System.out.println("Saldo Incial: " + miCuenta.dSaldo + " euros");

		// Depuracion. Provoca parada por ingreso con cantidad menor de 0
		miCuenta.ingresar(-100);
		System.out.println("Saldo Incial: " + miCuenta.dSaldo + " euros");

		miCuenta.ingresar(100);
		System.out.println("Saldo tras ingreso: " + miCuenta.dSaldo + " euros");

		miCuenta.ingresar(200);
		System.out.println("Saldo tras ingreso: " + miCuenta.dSaldo + " euros");

		// Depuracion. Provoca parada con codicion de tercer ingreso
		miCuenta.ingresar(300);
		System.out.println("Saldo tras ingreso: " + miCuenta.dSaldo + " euros");

		miCuenta.retirar(50);
		System.out.println("Saldo tras retirada: " + miCuenta.dSaldo + " euros");
	}
}