package gameOfLife.Logica;
import java.io.*;
import java.util.ArrayList;

import gameOfLife.Logica.Casilla;
import gameOfLife.Logica.Celula.*;
import gameOfLife.Constantes.*;
import gameOfLife.Excepciones.PalabraIncorrecta;


// TODO: Auto-generated Javadoc
/**
 * The Class Superficie.
 */
public class Superficie {
	
	/** The superficie. */
	private Celula[][] superficie;
	
	/** The libres. */
	private ArrayList<Casilla> casilla, libres;
	
	/** The columnas. */
	private int filas, columnas;
	
	/**
	 * Instantiates a new superficie.
	 *
	 * @param nf the nf
	 * @param nc the nc
	 */
	public Superficie(int nf, int nc){
		this.filas = nf;
		this.columnas = nc;
		this.casilla = new ArrayList<Casilla>(nf*nc);
		this.libres = new ArrayList<Casilla>(nf*nc);
		this.superficie = new Celula[nf][nc];
	}
	
	/**
	 * Paso.
	 *
	 * @param indice the indice
	 * @return the string
	 */
	public String paso(int indice){
		StringBuilder sb = new StringBuilder();
		if(casilla.get(indice) != null){
			int fila = casilla.get(indice).getFila();
			int columna = casilla.get(indice).getColumna();
			if(superficie[fila][columna].muerte()){
				sb.append(muerte(fila, columna));
				eliminarCelula(fila, columna);
			}else sb.append(movimiento(fila, columna));
		}return sb.toString();
	}
	
	
	
	/**
	 * Muerte.
	 *
	 * @param fila the fila
	 * @param columna the columna
	 * @return the string
	 */
	private String muerte(int fila, int columna){
		if(superficie[fila][columna].esComestible()) return (Textos.apoptosis(fila, columna));
		else return (Textos.explota(fila, columna));
	}
	
	/**
	 * Metodo usado en Mundo para crear una
	 * matriz con X celulas colocadas en ella.
	 *
	 * @param nsimples the nsimples
	 * @param ncomplejas the ncomplejas
	 */
	public void iniciar(int nsimples, int ncomplejas){	
		int fila, columna;
		while(casilla.size() < nsimples + ncomplejas){
			fila = random(this.filas);
			columna = random(this.columnas);
	    if(casilla.size() < nsimples)
	    	crearCelulaSimple(fila, columna);
	    else crearCelulaCompleja(fila, columna);
	    this.actualizarOcupadas();
	    }
	}
	
	/**
	 * Este metodo se usa para Actualizar un array con
	 * las casillas ocupadas para hacer un bucle posteriormente
	 * mas eficiente.
	 *
	 * @return the int
	 */
	public int actualizarOcupadas(){
		this.casilla.clear();
		for(int f = 0; f < this.filas; f++)
			for(int c = 0; c < this.columnas; c++)
				if(!vacia(f, c))
					this.casilla.add(new Casilla(f,c));
		return this.tamaño();
	}
	
	
	/**
	 * Tamaño.
	 *
	 * @return the int
	 */
	public int tamaño(){
		return casilla.size();
	}
	
	/**
	 * Fila aleatoria.
	 *
	 * @return the int
	 */
	public int filaAleatoria(){
		return random(this.filas);
	}
	
	/**
	 * Columna aleatoria.
	 *
	 * @return the int
	 */
	public int columnaAleatoria(){
		return random(this.columnas);
	}
	/**
	 * Actualizamos casillas libres en un rango de una celula para su posterior movimiento.
	 *
	 * @param fila the fila
	 * @param columna the columna
	 */
	public void actualizarLibres(int fila, int columna){
        this.libres.clear();
		for(int i = Math.max(fila-1, 0); i <= Math.min(fila+1, this.filas-1); i++)
			for(int j = Math.max(columna-1, 0); j <= Math.min(columna+1, this.columnas-1); j++)
				if(this.superficie[i][j] == null)
					this.libres.add(new Casilla(i, j));
	}
	
	/**
	 * Casilla aleatoria.
	 *
	 * @return the casilla
	 */
	public Casilla casillaAleatoria(){
		if(libres.size() >0)
		return libres.get(random(libres.size()));
		else return null;
	}
	
	/**
	 * Movimiento.
	 *
	 * @param fila the fila
	 * @param columna the columna
	 * @return the string
	 */
	public String movimiento(int fila, int columna){
		StringBuilder sb = new StringBuilder();
		this.superficie[fila][columna].ejecutaMovimiento(fila, columna, this, sb);
		return sb.toString();
	}
	
	/**
	 * Este metodo desplaza una celula a la siguiente casilla.
	 *
	 * @param fila the fila
	 * @param columna the columna
	 * @param nf the nf
	 * @param nc the nc
	 */
     public void moverCelula(int fila, int columna, int nf, int nc){	
		this.superficie[nf][nc] = this.superficie[fila][columna];
		this.superficie[fila][columna] = null;		
	}
	
	/**
	 * Vacia.
	 *
	 * @param fila the fila
	 * @param columna the columna
	 * @return true, if successful
	 */
	public boolean vacia(int fila, int columna){	
	   return (boolean)(this.superficie[fila][columna] == null);
	}
	
    /**
     * Pos valida.
     *
     * @return true, if successful
     */
    public boolean posValida(){
    	return (boolean) (libres.size() == 0);
	}
    
    /**
     * Tablero lleno.
     *
     * @return true, if successful
     */
    public boolean tableroLleno(){
    	return (boolean) (casilla.size() == this.filas*this.columnas);
    }
    
	/**
	 * Creacion del tablero	(visualizacion).
	 *
	 * @return the string
	 */
    public String toString(){
    	StringBuilder sb = new StringBuilder(this.filas*this.columnas);
    	
    	sb.append("\n");
		for(int f = 0; f < this.filas; f++){
			for(int c = 0; c < this.columnas; c++)
				if(vacia(f, c)) sb.append(" - ");
					else sb.append (this.superficie[f][c].muestraCelula());
			sb.append ("\n");
		}return sb.toString();
    }
    
    /**
     * Rango.
     *
     * @param fila the fila
     * @param columna the columna
     * @return true, if successful
     */
    public boolean rango(int fila, int columna) {
		if (fila < 0 || fila >= this.filas) 
			return false;
		else if (columna < 0 || columna >= this.columnas) 
			return false;
		return true;
	}

    /**
     * Para usar esComestible() hemos creado este metodo que indica si es comestible por
     * que haya una casilla vacia o por que haya una celula comestible.
     *
     * @param fila the fila
     * @param columna the columna
     * @return true, if successful
     */
    public boolean esComestible(int fila, int columna){
        if(this.superficie[fila][columna] == null || this.superficie[fila][columna].esComestible()) return true;
    	else return false;
    }
    
    /**
     * Dada una fila y una columna, crea una célula simple, 
     * realizando las comprobaciones pertinentes.
     *
     * @param fila the fila
     * @param columna the columna
     * @return true, if successful
     */
	public String crearCelulaSimple(int fila, int columna){
		   this.superficie[fila][columna] = new CelulaSimple();
		   return Textos.crearCelula(fila, columna);
	}
	
	/**
	 * Dada una fila y una columna, crea una cÃ©lula compleja, 
	 * realizando las comprobaciones pertinentes.
	 *
	 * @param fila the fila
	 * @param columna the columna
	 * @return true, if successful
	 */
	public String crearCelulaCompleja(int fila, int columna){
			this.superficie[fila][columna] = new CelulaCompleja();
			return Textos.crearCelula(fila, columna);
	}
	
	/**
	 * Eliminar una celula en el caso de que la posicion no este vacia.
	 *
	 * @param fila the fila
	 * @param columna the columna
	 * @return true, if successful
	 */
	public boolean eliminarCelula(int fila, int columna) {
		  if(this.superficie[fila][columna] != null){
			 this.superficie[fila][columna] = null;
			   return true;
			}else return false;
	}
	
	/**
	 * Dado un numero, devuelve un aleatorio entre 0 y el mismo.
	 *
	 * @param numero the numero
	 * @return the int
	 */
	public int random(int numero){
		return (int)Math.floor(Math.random()*(numero));
	}
	
	/**
	 * Devuelve true si la casilla esta vacia.
	 *
	 * @param casilla the casilla
	 * @return true, if successful
	 */
	public boolean casillaVacia(Casilla casilla){
		return (boolean)(casilla == null);
	}
	
	/**
	 * Eliminar una casilla.
	 *
	 * @param casilla the casilla
	 */
	public void eliminarCasilla(Casilla casilla){
		int i = 0; boolean fin = false;
		while(i < this.casilla.size() && !fin){
			if(this.casilla.get(i).equals(casilla)){
				this.casilla.remove(i);
				fin = true;
			}else i++;
		}
	}
	
	/**
	 * Este metodo indica si tenemos por casualidad una singularidad en nuestro juego
	 * (que este lleno de celulas complejas).
	 *
	 * @return the int
	 */
	public int juegoCorrupto(){
		int contador = 0;
			for(int i = 0; i < this.filas; i++)
				for(int j = 0; j < this.columnas; j++)
					if(this.superficie[i][j] != null)
					  if(this.superficie[i][j].esComestible())
						 contador++;
		return contador;
	}

	/**
	 * Load.
	 *
	 * @param bf the bf
	 * @param datoLista the dato lista
	 * @throws PalabraIncorrecta the palabra incorrecta
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void load(BufferedReader bf, String[] datoLista) throws PalabraIncorrecta, IOException{
		try{
		   if(datoLista[2].equalsIgnoreCase("simple") && datoLista.length == 5){
			           crearCelulaSimple(Integer.parseInt(datoLista[0]),Integer.parseInt(datoLista[1]));
			           superficie[Integer.parseInt(datoLista[0])][Integer.parseInt(datoLista[1])].cargarCelula(Integer.parseInt(datoLista[3]), Integer.parseInt(datoLista[4]));
		   }else if (datoLista[2].equalsIgnoreCase("compleja") && datoLista.length == 4){ 
					  	crearCelulaCompleja(Integer.parseInt(datoLista[0]),Integer.parseInt(datoLista[1]));
				  		superficie[Integer.parseInt(datoLista[0])][Integer.parseInt(datoLista[1])].cargarCelula(Integer.parseInt(datoLista[3]), 0);
		   }else throw new PalabraIncorrecta();
		 }catch(NumberFormatException e){
			   bf.close();
		 }
	}
	

	
	/**
	 * Savegame.
	 *
	 * @param bw the bw
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void savegame(BufferedWriter bw) throws IOException{
		for (int i = 0; i < this.filas; ++i) 
			for (int j = 0; j < this.columnas; ++j) {
				if (this.superficie[i][j] != null){
					bw.newLine();
					bw.write("" + i + " " + j + " ");
					superficie[i][j].guardarCelula(bw);		
	      }
      }
  }
}