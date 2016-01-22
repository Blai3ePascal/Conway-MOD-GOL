package gameOfLife.Logica.Mundo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import gameOfLife.Constantes.Textos;
import gameOfLife.Excepciones.IndicesFueraDeRango;
import gameOfLife.Excepciones.PalabraIncorrecta;
import gameOfLife.Logica.Superficie;

// TODO: Auto-generated Javadoc
/**
 * The Class MundoSimple.
 */
public class MundoSimple extends Mundo{
	
	/** The celulas simples. */
	private int celulasSimples;
	
	
	/**
	 * Instantiates a new mundo simple.
	 *
	 * @param filas the filas
	 * @param columnas the columnas
	 * @param celulasSimples the celulas simples
	 */
	public MundoSimple(int filas, int columnas, int celulasSimples) {
		super(filas, columnas);
		this.celulasSimples = celulasSimples;
		this.inicializaMundo(filas, columnas);
	}
	
	/**
	 * Instantiates a new mundo simple.
	 */
	public MundoSimple(){
		super();
		this.celulasSimples = 0;
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Mundo.Mundo#inicializaMundo(int, int)
	 */
	@Override
	public String inicializaMundo(int filas, int columnas) {
		this.superficie = new Superficie(filas, columnas);
		this.superficie.actualizarOcupadas();
		this.superficie.iniciar(this.celulasSimples, 0);
		return (Textos.conway());
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Mundo.Mundo#crearCelula(int, int)
	 */
	@Override
	public String crearCelula(int fila, int columna)throws IndicesFueraDeRango{
	  if(this.superficie.rango(fila, columna)){
		if(this.superficie.vacia(fila, columna))
			return this.superficie.crearCelulaSimple(fila, columna);
		 else return Textos.errorOcupada();	
	  }else throw new IndicesFueraDeRango();
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Mundo.Mundo#reinciar()
	 */
	@Override
	public Mundo reinciar() {
		return new MundoSimple(this.filas, this.columnas, this.celulasSimples);
	}
	
	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Mundo.Mundo#save(java.io.BufferedWriter)
	 */
	public void save(BufferedWriter bw) throws NumberFormatException, IOException {
		bw.write("simple");
		bw.newLine();
		bw.write("" + this.filas);
		bw.newLine();
		bw.write("" + this.columnas);
		superficie.savegame(bw);
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Mundo.Mundo#load(java.io.BufferedReader)
	 */
	@Override
	public void load(BufferedReader bf) throws NumberFormatException, IOException, PalabraIncorrecta {
		String dato;
		try{
			this.filas = Integer.parseInt(bf.readLine());
			this.columnas = Integer.parseInt(bf.readLine());
			this.inicializaMundo(this.filas, this.columnas);
		}catch(NumberFormatException e){
			throw new IOException();
		}while((dato = bf.readLine()) != null){
			String[] datoLista = dato.split(" ");
			if(datoLista[2].equalsIgnoreCase("simple")) this.celulasSimples++;
			else throw new PalabraIncorrecta();
			       superficie.load(bf, datoLista);
		}

	}

}
