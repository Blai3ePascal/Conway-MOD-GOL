package gameOfLife.Comando;

import gameOfLife.Control.Controlador;

// TODO: Auto-generated Javadoc
/**
 * The Class ComandoGuardar.
 */
public class ComandoGuardar implements Comando{

	/** The nom fichero. */
	private String nomFichero;
	
	/**
	 * Instantiates a new comando guardar.
	 *
	 * @param fich the fich
	 */
	public ComandoGuardar(String fich){
		this.nomFichero = fich;
	}
	
	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#ejecuta(gameOfLife.Control.Controlador)
	 */
	@Override
	public String ejecuta(Controlador controlador) {
		return controlador.guardar(this.nomFichero);
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#parsea(java.lang.String[])
	 */
	@Override
	public Comando parsea(String[] cadenaComando){
		if(cadenaComando[0].equalsIgnoreCase("guardar") && cadenaComando.length == 2){
			return new ComandoGuardar(cadenaComando[1]);
		}
		else  return null;
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#textoAyuda()
	 */
	@Override
	public String textoAyuda() {
		return " GUARDAR (fichero): Guarda la partida en el fichero indicado \n";
	}
}
