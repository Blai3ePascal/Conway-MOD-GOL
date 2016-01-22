package gameOfLife.Logica.Mundo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

import gameOfLife.Constantes.Textos;
import gameOfLife.Excepciones.IndicesFueraDeRango;
import gameOfLife.Excepciones.PalabraIncorrecta;
import gameOfLife.Logica.Superficie;

// TODO: Auto-generated Javadoc
/**
 * The Class MundoComplejo.
 */
public class MundoComplejo extends Mundo{

	/** The celulas simples. */
	private int celulasSimples;
	
	/** The celulas complejas. */
	private int celulasComplejas;
	
	/** The sc. */
	private Scanner sc;
	
	/**
	 * Instantiates a new mundo complejo.
	 *
	 * @param filas the filas
	 * @param columnas the columnas
	 * @param celulasSimples the celulas simples
	 * @param celulasComplejas the celulas complejas
	 */
	public MundoComplejo(int filas, int columnas, int celulasSimples, int celulasComplejas) {
		super(filas, columnas);
		sc = new Scanner(System.in);
		this.celulasSimples = celulasSimples;
		this.celulasComplejas = celulasComplejas;
		this.inicializaMundo(filas, columnas);
	}
	
	/**
	 * Instantiates a new mundo complejo.
	 */
	public MundoComplejo() {
		super();
		sc = new Scanner(System.in);
		this.celulasSimples = 0;
		this.celulasComplejas = 0;
	}
	
	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Mundo.Mundo#inicializaMundo(int, int)
	 */
	@Override
	public String inicializaMundo(int fila, int columnas) {
		this.superficie = new Superficie(fila, columnas);
		this.superficie.actualizarOcupadas();
		this.superficie.iniciar(this.celulasSimples, this.celulasComplejas);
		return (Textos.conway());
	}
	
	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Mundo.Mundo#crearCelula(int, int)
	 */
	@Override
	public String crearCelula(int fila, int columnas) throws IndicesFueraDeRango{
	   if(superficie.rango(fila, columnas)){
		if(superficie.vacia(fila, columnas)){
			System.out.print(Textos.eligeTipo());
			switch(this.sc.nextInt()){
				case 1: return this.superficie.crearCelulaCompleja(fila, columnas);
				case 2: return this.superficie.crearCelulaSimple(fila, columnas);
				default: return Textos.tipoInvalido();
			}
		 }else return Textos.errorOcupada();
	   }else throw new IndicesFueraDeRango();
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Mundo.Mundo#reinciar()
	 */
	@Override
	public Mundo reinciar() {
		return new MundoComplejo(this.filas, this.columnas, this.celulasSimples, this.celulasComplejas);
	}

	/* (non-Javadoc)
	 * @see gameOfLife.Logica.Mundo.Mundo#save(java.io.BufferedWriter)
	 */
	@Override
	public void save(BufferedWriter bw) throws NumberFormatException, IOException {
		bw.write("complejo");
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
	public void load(BufferedReader bf) throws NumberFormatException, IOException, PalabraIncorrecta{
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
			else if(datoLista[2].equalsIgnoreCase("compleja")) this.celulasComplejas++;
			else throw new PalabraIncorrecta();
		try{
		    superficie.load(bf, datoLista);
		}catch(NullPointerException e){
			throw new IOException();
		}
	 }	
	}
}
