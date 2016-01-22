package gameOfLife.Comando;

import gameOfLife.Control.Controlador;


// TODO: Auto-generated Javadoc
/**
 * The Class ComandoCargar.
 */
public class ComandoCargar implements Comando{

	/** The nom fichero. */
	private String nomFichero;
	
	/**
	 * Instantiates a new comando cargar.
	 *
	 * @param fichero the fichero
	 */
	public ComandoCargar(String fichero){
		this.nomFichero = fichero;
	}
	
	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#ejecuta(gameOfLife.Control.Controlador)
	 */
	@Override
	public String ejecuta(Controlador controlador){
		return controlador.cargar(this.nomFichero);
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#parsea(java.lang.String[])
	 */
	@Override
	public Comando parsea(String[] cadenaComando) {
		if(cadenaComando[0].equalsIgnoreCase("cargar") && cadenaComando.length == 2){
			return new ComandoCargar(cadenaComando[1]);
		}
		else  return null;
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#textoAyuda()
	 */
	@Override
	public String textoAyuda() {
		return " CARGAR (FICHERO): Carga una partida guardada en el fichero indicado \n";
	}
}
