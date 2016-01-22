
package gameOfLife.Comando;

import gameOfLife.Control.Controlador;
import gameOfLife.Excepciones.FormatoNumericoIncorrecto;
import gameOfLife.Excepciones.IndicesFueraDeRango;

// TODO: Auto-generated Javadoc
/**
 * The Class ComandoCrearSimple.
 */
public class ComandoCrear implements Comando{

	/** The fila. */
	private int fila;
	
	/** The columna. */
	private int columna;

	/**
	 * Instantiates a new comando crear simple.
	 *
	 * @param fila the fila
	 * @param columna the columna
	 */
	public ComandoCrear(int fila, int columna) {
		this.fila=fila;
		this.columna=columna;
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#ejecuta(gameOfLife.Control.Controlador)
	 */
	public String ejecuta(Controlador controlador){
		return controlador.crea(fila,columna);
	}
	

	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#parsea(java.lang.String[])
	 */
	public Comando parsea(String[] cadenaComando) throws FormatoNumericoIncorrecto, IndicesFueraDeRango{
		if (cadenaComando.length == 3){
			if (cadenaComando[0].equalsIgnoreCase("crearcelula")){
				try{
					this.fila=Integer.parseInt(cadenaComando[1]);
					this.columna=Integer.parseInt(cadenaComando[2]);
					return new ComandoCrear(this.fila, this.columna);	
				}catch(NumberFormatException e){
					throw new FormatoNumericoIncorrecto();
				}
			}else return null;
		}return null;
	}


	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#textoAyuda()
	 */
	public String textoAyuda() {
		return " CREARCELULA F C: crea una celula en la posición (f,c) si es posible\n";
	}
}
