package gameOfLife.Comando;

import gameOfLife.Control.Controlador;
import gameOfLife.Excepciones.ErrorDeInicializacion;
import gameOfLife.Logica.Mundo.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ComandoJugar.
 */
public class ComandoJugar implements Comando{

	/** The filas. */
	private int filas;
	
	/** The columnas. */
	private int columnas;
	
	/** The simples. */
	private int simples;
	
	/** The complejas. */
	private int complejas;
	
	/** The mundo. */
	private Mundo mundo;
	
	/**
	 * Instantiates a new comando jugar.
	 *
	 * @param f the f
	 * @param c the c
	 * @param simples the simples
	 */
	public ComandoJugar(int f, int c, int simples){//SIMPLES
		this.filas = f;
		this.columnas = c;
		this.simples = simples;
		this.mundo = new MundoSimple(f, c, simples);
	}
	
	/**
	 * Instantiates a new comando jugar.
	 *
	 * @param f the f
	 * @param c the c
	 * @param simples the simples
	 * @param complejas the complejas
	 */
	public ComandoJugar(int f, int c, int simples, int complejas){//COMPLEJAS
		this.filas = f;
		this.columnas = c;
		this.simples = simples;
		this.complejas = complejas;
		this.mundo = new MundoComplejo(f, c, simples, complejas);
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#ejecuta(gameOfLife.Control.Controlador)
	 */
	@Override
	public String ejecuta(Controlador controlador) {
		return controlador.juega(this.mundo);
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#parsea(java.lang.String[])
	 */
	@Override
	public Comando parsea(String[] cadenaComando) throws ErrorDeInicializacion{
			if (cadenaComando[0].equalsIgnoreCase("jugar") && cadenaComando.length >= 5){
					String mundo = cadenaComando[1];

					this.filas = Integer.parseInt(cadenaComando[2]);
					this.columnas = Integer.parseInt(cadenaComando[3]);
					this.simples = Integer.parseInt(cadenaComando[4]);
					if(mundo.equalsIgnoreCase("complejo") && cadenaComando.length == 6){
						this.complejas = Integer.parseInt(cadenaComando[5]);
						if((this.filas * this.columnas) < (this.simples + this.complejas) || (this.simples < 0 | this.complejas <0))
							throw new ErrorDeInicializacion();
						return new ComandoJugar(this.filas, this.columnas, this.simples, this.complejas);
					}else if(mundo.equalsIgnoreCase("simple") && cadenaComando.length == 5 ){
						if(((this.filas * this.columnas) < this.simples) || (this.simples < 0 ))
							throw new ErrorDeInicializacion();
                        return new ComandoJugar(this.filas, this.columnas, this.simples);
					}
			}return null;
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Comando.Comando#textoAyuda()
	 */
	@Override
	public String textoAyuda() {
		return " JUGAR SIMPLE F C S: comienza una partida de células simples \n JUGAR COMPLEJA F C S C: comienza una partida de células simples y complejas \n";
	}

}
