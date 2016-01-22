
package gameOfLife.Logica.Celula;

import java.io.BufferedWriter;
import java.io.IOException;

import gameOfLife.Constantes.Constantes;
import gameOfLife.Constantes.Textos;
import gameOfLife.Logica.Casilla;
import gameOfLife.Logica.Superficie;

// TODO: Auto-generated Javadoc
/**
 * The Class CelulaSimple.
 */
public class CelulaSimple implements Celula{

	/** The pasos reprod. */
	private int pasosReprod;
	
	/** The pasos quieta. */
	private int pasosQuieta;
	
	/**
	 * Instantiates a new celula simple.
	 */
	public CelulaSimple(){
		pasosReprod = Constantes.NUM_REPR;
        pasosQuieta = Constantes.NUM_PASOS;
	}
	/**
	 * Incrementar Pasos significa que nosotros, decrementamos el contador
	 * Para el usuario eso incrementa los pasos dados.
	 */
	public void seMueve(){
		this.pasosQuieta = 1;
		this.pasosReprod--;
	}
	
	/**
	 * Aumentamos el numero de "turnos" que ha estado quieta la celula
	 * Esto en la funcion se transforma en decrementar los pasos.
	 */
	public void seQuedaQuieta(){
		this.pasosQuieta--;
	}
	
	/**
	 * Boolean que indica si se puede reproducir.
	 *
	 * @return true, if successful
	 */
	public boolean reproduccion(){
		return pasosReprod == Constantes.PASOS_REPR;
	}
	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Celula.Celula#muestraCelula()
	 */
	public String muestraCelula(){
		return " X ";
	}
	

	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Celula.Celula#muerte()
	 */
	public boolean muerte(){
		return pasosQuieta == Constantes.MAX_SIN_MOV;
	}
	
	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Celula.Celula#esComestible()
	 */
	public boolean esComestible(){
		return true;
	}

	/**
	 * Movimiento de una celula simple.
	 *
	 * @param fila the fila
	 * @param columna the columna
	 * @param superficie the superficie
	 * @param sb the sb
	 * @return the casilla
	 */
	public String ejecutaMovimiento(int fila, int columna, Superficie superficie, StringBuilder sb){
		Casilla nextCasilla = null;
		superficie.actualizarLibres(fila, columna);
		int nf = 0, nc = 0;
		nextCasilla = superficie.casillaAleatoria();
		if(this.reproduccion() && nextCasilla == null){
			superficie.eliminarCelula(fila, columna);
			sb.append(Textos.mansionManiac(fila, columna));
		}else if(!superficie.posValida()){
				nf = nextCasilla.getFila();
				nc = nextCasilla.getColumna();
				superficie.moverCelula(fila, columna, nf, nc); 	
				sb.append(Textos.movimientoCelular(fila, columna, nf, nc));
				if(this.reproduccion()){
					superficie.crearCelulaSimple(nf, nc);
					superficie.crearCelulaSimple(fila, columna);
					sb.append(Textos.nacimientoCelular(fila, columna, nf, nc));
				}else this.seMueve();
			}else this.seQuedaQuieta();
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Celula.Celula#guardarCelula(java.io.BufferedWriter)
	 */
	public void guardarCelula(BufferedWriter bf) throws IOException {
		bf.write("simple " + this.pasosReprod + " " + this.pasosQuieta);
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Celula.Celula#cargarCelula(int, int)
	 */
	public void cargarCelula(int pasosRep, int pasosQuieta){
        this.pasosReprod = pasosRep;
        this.pasosQuieta = pasosQuieta;
	}
	
}
