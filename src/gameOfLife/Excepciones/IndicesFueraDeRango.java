package gameOfLife.Excepciones;

import gameOfLife.Constantes.Textos;

// TODO: Auto-generated Javadoc
/**
 * The Class IndicesFueraDeRango.
 */
@SuppressWarnings("serial")
public class IndicesFueraDeRango extends Exception{
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	public String toString(){
		return  Textos.fueraDeRango();
	}
}
