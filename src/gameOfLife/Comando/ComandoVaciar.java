/*
 * 
 */
package gameOfLife.Comando;

import gameOfLife.Control.Controlador;

// TODO: Auto-generated Javadoc
/**
 * The Class ComandoVaciar.
 */
public class ComandoVaciar implements Comando{


	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#ejecuta(gameOfLife.Logica.Mundo)
	 */
	public String ejecuta(Controlador controlador) {
		return controlador.vacia();
	}


	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#parsea(java.lang.String[])
	 */
	public Comando parsea(String[] cadenaComando) {
		if(cadenaComando[0].equalsIgnoreCase("vaciar")) 
			  return new ComandoVaciar();
		else  return null;
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#textoAyuda()
	 */
	public String textoAyuda() {
		return " VACIAR: crea un mundo vacio";
	}

}
