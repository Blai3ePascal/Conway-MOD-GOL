/*
 * 
 */
package gameOfLife.Comando;

import gameOfLife.Control.Controlador;


// TODO: Auto-generated Javadoc
/**
 * The Class ComandoAyuda.
 */
public class ComandoAyuda implements Comando{

	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#ejecuta(gameOfLife.Logica.Mundo)
	 */
	public String ejecuta(Controlador controlador){
		return ParserComando.AyudaComandos();
	}
	
	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#parsea(java.lang.String[])
	 */
	public Comando parsea(String[] cadenaComando){
		if(cadenaComando[0].equalsIgnoreCase("ayuda")) 
			  return new ComandoAyuda();
		else return null;
	}
	
	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#textoAyuda()
	 */
	public String textoAyuda(){
		return " AYUDA: muestra esta ayuda\n";
	}
}
