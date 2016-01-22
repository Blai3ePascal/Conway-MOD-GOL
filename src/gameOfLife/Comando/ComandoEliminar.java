
package gameOfLife.Comando;

import gameOfLife.Constantes.Textos;
import gameOfLife.Control.Controlador;

// TODO: Auto-generated Javadoc
/**
 * The Class ComandoEliminar.
 */
public class ComandoEliminar implements Comando{

	/** The fila. */
	private int fila;
	
	/** The columna. */
	private int columna;

	/**
	 * Instantiates a new comando eliminar.
	 *
	 * @param fila the fila
	 * @param columna the columna
	 */
	public ComandoEliminar(int fila, int columna) {
		this.fila=fila;
		this.columna=columna;
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#ejecuta(gameOfLife.Logica.Mundo)
	 */
	public String ejecuta(Controlador controlador){
		return controlador.elimina(fila, columna);
	}
	
	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#parsea(java.lang.String[])
	 */
	public Comando parsea(String[] cadenaComando) {
		if (cadenaComando.length == 3){
			if (cadenaComando[0].equalsIgnoreCase("eliminarcelula")){
				try{
				this.fila=Integer.parseInt(cadenaComando[1]);
				this.columna=Integer.parseInt(cadenaComando[2]);
				return new ComandoEliminar(this.fila, this.columna);
				}catch(NumberFormatException e){
					System.out.println(Textos.posiciones());
				}
			}else return null;
		}return null;
	}
	

	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#textoAyuda()
	 */
	public String textoAyuda() {
		return " ELIMINARCELULA F C: elimina una celula de la posicion (f,c) si es posible\n";
	}

}
