package gameOfLife.Logica;

// TODO: Auto-generated Javadoc
/**
 * The Class Casilla.
 */
public class Casilla {
	
	/** The fila. */
	private int fila;
	
	/** The columna. */
	private int columna;
	
    /**
     * Instantiates a new casilla.
     *
     * @param fila the fila
     * @param columna the columna
     */
    public Casilla(int fila, int columna){
		this.fila = fila;
		this.columna = columna;
	}
    
    /**
     * Preguntar si se puede hacer esto, tiene pinta de que no.
     *
     * @param aux the aux
     * @return true, if successful
     */
    public boolean equals(Casilla aux){
    	return aux.fila == this.fila && aux.columna == this.columna;
    }
    
	/**
	 * Gets the fila.
	 *
	 * @return the fila
	 */
	public int getFila() {
		return fila;
	}

	/**
	 * Gets the columna.
	 *
	 * @return the columna
	 */
	public int getColumna() {
		return columna;
	}
}
