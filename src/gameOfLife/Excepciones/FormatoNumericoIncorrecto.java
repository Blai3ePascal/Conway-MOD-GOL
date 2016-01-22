package gameOfLife.Excepciones;

import gameOfLife.Constantes.Textos;

// TODO: Auto-generated Javadoc
/**
 * The Class FormatoNumericoIncorrecto.
 */
@SuppressWarnings("serial")
public class FormatoNumericoIncorrecto extends Exception{
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	public String toString(){
		return  Textos.posiciones();
	}
}
