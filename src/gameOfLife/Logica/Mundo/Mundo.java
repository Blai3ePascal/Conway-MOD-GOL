/*
 * 
 */
package gameOfLife.Logica.Mundo;

import java.io.*;

import gameOfLife.Constantes.Textos;
import gameOfLife.Excepciones.IndicesFueraDeRango;
import gameOfLife.Excepciones.PalabraIncorrecta;
import gameOfLife.Logica.Superficie;


// TODO: Auto-generated Javadoc
/**
 * The Class Mundo.
 */
public abstract class Mundo {
	
	/** The filas. */
	protected int filas;
	
	/** The columnas. */
	protected int columnas;
	
	/** The superficie. */
	protected Superficie superficie;

	
	/**
	 * Instantiates a new mundo.
	 *
	 * @param filas the filas
	 * @param columnas the columnas
	 */
	public Mundo(int filas, int columnas){
		this.filas = filas;
		this.columnas = columnas;
		this.superficie = new Superficie(filas, columnas);
	}
	
	/**
	 * Instantiates a new mundo.
	 */
	public Mundo(){
		this.filas = 0;
		this.columnas = 0;
		this.superficie = null;
	}
	
	/**
	 * Inicializa mundo.
	 *
	 * @param fila the fila
	 * @param columnas the columnas
	 * @return the string
	 */
	public abstract String inicializaMundo(int fila, int columnas);
	
	/**
	 * Crear celula.
	 *
	 * @param fila the fila
	 * @param columnas the columnas
	 * @return the string
	 * @throws IndicesFueraDeRango the indices fuera de rango
	 */
	public abstract String crearCelula(int fila, int columnas) throws IndicesFueraDeRango;
	
	/**
	 * Reinciar.
	 *
	 * @return the mundo
	 */
	public abstract Mundo reinciar();
	
	/**
	 * Load.
	 *
	 * @param bf the bf
	 * @throws NumberFormatException the number format exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws PalabraIncorrecta the palabra incorrecta
	 */
	public abstract void load(BufferedReader bf) throws NumberFormatException, IOException, PalabraIncorrecta;
	
	/**
	 * Save.
	 *
	 * @param bw the bw
	 * @throws NumberFormatException the number format exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public abstract void save(BufferedWriter bw) throws NumberFormatException, IOException;
	
	/**
	 * Eliminamos celula en X posicion.
	 *
	 * @param fila the fila
	 * @param columna the columna
	 * @return the string
	 */
	public String eliminarCelula(int fila, int columna){
	     if(this.superficie.eliminarCelula(fila, columna))
				return(Textos.eliminarPosicion(fila, columna));
	     else return(Textos.errorVacio());
	}
	
	/**
	 * Realizamos un paso de evolucion de tablero este metodo controla el bucle.
	 *
	 * @return the string
	 */
	public String paso(){
		int indice = 0, total = this.superficie.actualizarOcupadas();
		StringBuilder sb = new StringBuilder();
	    if(total == 0) sb.append(Textos.imposibleDeJugar());
		else{ 
			while(indice < total){
				sb.append( superficie.paso(indice));
				indice++;
				total = this.superficie.tamaño();
			}
		}
	    return sb.toString();
	}
	
	/**
	 * Vaciamos el tablero.
	 *
	 * @return the string
	 */
	public String vaciar(){
		this.superficie.actualizarOcupadas();
		this.superficie = new Superficie(this.filas, this.columnas);
		return(Textos.vaciar());	
	}

	/**
	 * Imprimimos el tablero.
	 *
	 * @return the string
	 */
	public String tablero(){
		return superficie.toString();
	}
	
	/**
	 * Salir de "juego" y muestra un texto despidiendose del usuario.
	 *
	 * @return the string
	 */
	public String salir() {
		return Textos.finSimulacion();
	}
}
