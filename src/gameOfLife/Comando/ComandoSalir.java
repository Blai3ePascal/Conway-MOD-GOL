/*
 * 
 */
package gameOfLife.Comando;

import gameOfLife.Control.Controlador;

// TODO: Auto-generated Javadoc
/**
 * The Class ComandoSalir.
 */
public class ComandoSalir implements Comando{
	

	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#ejecuta(gameOfLife.Logica.Mundo)
	 */
	public String ejecuta(Controlador controlador) {
		return controlador.salir();
	}


	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#parsea(java.lang.String[])
	 */
	public Comando parsea(String[] cadenaComando) {
		if(cadenaComando[0].equalsIgnoreCase("salir")) 
			  return new ComandoSalir();
		else  return null;
	}


	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#textoAyuda()
	 */
	public String textoAyuda() {
		return " SALIR: cierra la aplicación\n";
	}

}
