/*
 * 
 */
package gameOfLife.Comando;

import gameOfLife.Control.Controlador;
import gameOfLife.Excepciones.ErrorDeInicializacion;
import gameOfLife.Excepciones.FormatoNumericoIncorrecto;
import gameOfLife.Excepciones.IndicesFueraDeRango;
import gameOfLife.Excepciones.PalabraIncorrecta;

// TODO: Auto-generated Javadoc
/**
 * The Interface Comando.
 */
public interface Comando {

	/**
	 * Ejecuta.
	 *
	 * @param controlador the mundo
	 * @return the string
	 * @throws PalabraIncorrecta the palabra incorrecta
	 */
	public abstract String ejecuta(Controlador controlador) throws PalabraIncorrecta;
	
	/**
	 * Parsea.
	 *
	 * @param cadenaComando the cadena comando
	 * @return the comando
	 * @throws FormatoNumericoIncorrecto the formato numerico incorrecto
	 * @throws ErrorDeInicializacion the error de inicializacion
	 * @throws IndicesFueraDeRango the indices fuera de rango
	 * @throws NumberFormatException the number format exception
	 */
	public abstract Comando parsea(String[] cadenaComando) throws FormatoNumericoIncorrecto, ErrorDeInicializacion, IndicesFueraDeRango;
	
	/**
	 * Texto ayuda.
	 * @return the string
	 */
	public abstract String textoAyuda();
	
}
