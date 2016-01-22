
package gameOfLife.Logica.Celula;

import java.io.BufferedWriter;
import java.io.IOException;

import gameOfLife.Constantes.Constantes;
import gameOfLife.Constantes.Textos;
import gameOfLife.Logica.Casilla;
import gameOfLife.Logica.Superficie;

// TODO: Auto-generated Javadoc
/**
 * The Class CelulaCompleja.
 */
public class CelulaCompleja implements Celula{

	/** The comidas. */
	private int comidas;
	
	/**
	 * Instantiates a new celula compleja.
	 */
	public CelulaCompleja(){
		super();
		this.comidas = Constantes.MAX_COMER;
	}
	
	/**
	 * Comidas.
	 *
	 * @return the int
	 */
	public int comidas(){
		return this.comidas;
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Celula.Celula#muestraCelula()
	 */
	public String muestraCelula(){
		return " * ";
	}
	
	/**
	 * Come.
	 */
	public void come(){	
		this.comidas++;
	}
	
	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Celula.Celula#muerte()
	 */
	public boolean muerte(){
		return (boolean) (this.comidas == Constantes.MIN_EXPLOTA);
	}
	
	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Celula.Celula#esComestible()
	 */
	public boolean esComestible(){
		return false;
	}
	
	/**
	 * En esta clase, generalizamos el movimiento de las celulas Complejas
	 * Devolvemos una casilla.
	 *
	 * @param fila the fila
	 * @param columna the columna
	 * @param superficie the superficie
	 * @param sb the sb
	 * @return the casilla
	 */
	public String ejecutaMovimiento(int fila, int columna, Superficie superficie, StringBuilder sb){
		int nf = 0, nc = 0;
		if(superficie.juegoCorrupto() != 0 || !superficie.tableroLleno()){
			do{
				nf = superficie.filaAleatoria();
				nc = superficie.columnaAleatoria();	
			}while(!superficie.esComestible(nf, nc));

			if(superficie.vacia(nf, nc) || superficie.juegoCorrupto()== 0){
				superficie.moverCelula(fila, columna, nf, nc);
				sb.append(Textos.comer(fila, columna, nf, nc, "NO "));
			}
			else{
				superficie.eliminarCasilla(new Casilla(nf, nc));
				superficie.moverCelula(fila, columna, nf, nc);
				this.come();
				sb.append(Textos.comer(fila, columna, nf, nc, ""));
			}
		}
		return sb.toString();	
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Celula.Celula#guardarCelula(java.io.BufferedWriter)
	 */
	@Override
	public void guardarCelula(BufferedWriter bf) throws IOException {
		bf.write("compleja "+ this.comidas);
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Celula.Celula#cargarCelula(int, int)
	 */
	@Override
	public void cargarCelula(int pasosRep, int pasosQuieta) {
		this.comidas = pasosRep;
	}
}
