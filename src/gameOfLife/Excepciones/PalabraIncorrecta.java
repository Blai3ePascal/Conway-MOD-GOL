package gameOfLife.Excepciones;

import gameOfLife.Constantes.Textos;

// TODO: Auto-generated Javadoc
/**
 * The Class PalabraIncorrecta.
 */
@SuppressWarnings("serial")
public class PalabraIncorrecta extends Exception{
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	public String toString(){
		return  Textos.palabraIncorrecta();
	}
}
