/*
 * 
 */
package gameOfLife.Comando;

import gameOfLife.Control.Controlador;

// TODO: Auto-generated Javadoc
/**
 * The Class ComandoIniciar.
 */
public class ComandoIniciar implements Comando{


	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#ejecuta(gameOfLife.Logica.Mundo)
	 */
	public String ejecuta(Controlador controlador) {
		return controlador.inicia();
	}


	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#parsea(java.lang.String[])
	 */
	public Comando parsea(String[] cadenaComando) {
		if(cadenaComando[0].equalsIgnoreCase("iniciar")) 
			  return new ComandoIniciar();
		else  return null;
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#textoAyuda()
	 */
	public String textoAyuda() {
		return " INICIAR: inicia una nueva simulacion\n";
	}

}
