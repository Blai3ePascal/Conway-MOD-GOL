
package gameOfLife.Logica.Celula;
import java.io.BufferedWriter;
import java.io.IOException;

import gameOfLife.Logica.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Celula.
 */
public interface Celula {

	
	/**
	 * Cargar celula.
	 *
	 * @param pasosRep the pasos rep
	 * @param pasosQuieta the pasos quieta
	 */
	public abstract void cargarCelula(int pasosRep, int pasosQuieta);
	
	/**
	 * Boolean que indica si tiene que morir.
	 *
	 * @return true, if successful
	 */
	public abstract boolean muerte();
	
	/**
	 * Componemos una estructura celular para visualizarla.
	 *
	 * @return the string
	 */
	public abstract String muestraCelula();
	
	/**
	 * Ejecuta movimiento.
	 *
	 * @param f the f
	 * @param c the c
	 * @param s the s
	 * @param sb the sb
	 * @return the casilla
	 */
	public abstract String ejecutaMovimiento(int f, int c, Superficie s, StringBuilder sb);
	
	/**
	 * Es comestible.
	 *
	 * @return true, if successful
	 */
	public abstract boolean esComestible();

	/**
	 * Guardar celula.
	 *
	 * @param bf the bf
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public abstract void guardarCelula(BufferedWriter bf) throws IOException;
}
