package gameOfLife.Main;
import java.util.*;

import gameOfLife.Logica.Mundo.*;
import gameOfLife.Control.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {
	
	/** The controlador. */
	private static Controlador controlador;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Mundo mundo = new MundoSimple(5, 6, 7);
		controlador = new Controlador(sc, mundo);
		controlador.juega(mundo);
		controlador.realizaSimulacion(mundo);
	}
}
