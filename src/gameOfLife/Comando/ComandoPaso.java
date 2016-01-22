/*
 * 
 */
package gameOfLife.Comando;

import gameOfLife.Control.Controlador;

// TODO: Auto-generated Javadoc
/**
 * The Class ComandoPaso.
 */
public class ComandoPaso implements Comando{
    
	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#ejecuta(gameOfLife.Logica.Mundo)
	 */
	public String ejecuta(Controlador controlador) {
		return controlador.daUnPaso();
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#parsea(java.lang.String[])
	 */
	public Comando parsea(String[] cadenaComando) {
		if(cadenaComando[0].equalsIgnoreCase("paso")) 
			  return new ComandoPaso();
		else  return null;
	}


	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#textoAyuda()
	 */
	public String textoAyuda() {
		return " PASO: realiza un paso en la simulacion\n";
	}

}
