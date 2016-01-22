package gameOfLife.Excepciones;

import gameOfLife.Constantes.Textos;

// TODO: Auto-generated Javadoc
/**
 * The Class ErrorDeInicializacion.
 */
@SuppressWarnings("serial")
public class ErrorDeInicializacion extends Exception{
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	public String toString(){
		return Textos.errorInicializacion();
	}
}
