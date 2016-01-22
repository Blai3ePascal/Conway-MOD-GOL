package gameOfLife.Control;
import gameOfLife.Comando.Comando;
import gameOfLife.Comando.ParserComando;
import gameOfLife.Constantes.Textos;
import gameOfLife.Excepciones.*;
import gameOfLife.Logica.Mundo.*;

import java.io.*;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Controlador.
 */
public class Controlador {
	/** The sc. */
	private Scanner sc; 
	
	/** The mundo. */
	private Mundo mundo, copiaAuxiliar;
	
	/** The sb. */
	private StringBuilder sb;
	
	/** The bf. */
	private BufferedReader bf;
	
	/** The bw. */
	private BufferedWriter bw;
	
	/** The simulacion terminada. */
	private boolean simulacionTerminada;
	
	/**
	 * Instantiates a new controlador.
	 *
	 * @param sc the sc
	 * @param mundo the mundo
	 */
	public Controlador(Scanner sc, Mundo mundo){
		this.bw = null;
		this.bf =  null;
		this.simulacionTerminada = false;
		this.sc = sc;
		this.mundo = mundo;
		this.copiaAuxiliar = mundo;
		this.sb = new StringBuilder();
	}
	
	
	/**
	 * Este bucle realiza toda la simulacion del juego.
	 *
	 * @param mundo the mundo
	 */
	public void realizaSimulacion(Mundo mundo){
		String opcion;
		 while(!this.simulacionTerminada){
			 sb.append(this.mundo.tablero());
			 sb.append(Textos.comando());
			 System.out.print(sb.toString());
			 sb.setLength(0);
			 opcion = sc.nextLine();
			 String[] cmdArray = opcion.split(" ");
			 try{
			 Comando comando = ParserComando.parseaComando(cmdArray);
				try {
					sb.append(comando.ejecuta(this));
				} catch (PalabraIncorrecta e) {
					System.out.println(e.toString());
				} catch (NullPointerException e){
                   sb.append(Textos.errorNoComando());
				}
			 }catch (NumberFormatException e) {
				 System.out.println(Textos.posiciones());
			 }catch (FormatoNumericoIncorrecto | ErrorDeInicializacion | IndicesFueraDeRango  e){
				System.out.println (e.toString());
			 }
		}System.out.print(sb.toString());
	 }	
	
	/**
	 * Da un paso.
	 *
	 * @return the string
	 */
	public String daUnPaso(){
		return this.mundo.paso();
	}

	/**
	 * Elimina.
	 *
	 * @param fila the fila
	 * @param columna the columna
	 * @return the string
	 */
	public String elimina(int fila, int columna){
		try{
		   return this.mundo.eliminarCelula(fila, columna);
		}catch(ArrayIndexOutOfBoundsException e){
			   return Textos.posiciones();
		}
	}
	
	/**
	 * Inicia.
	 *
	 * @return the string
	 */
	public String inicia(){
		this.mundo = this.mundo.reinciar();
		return Textos.conway();
	}
	
	/**
	 * Vacia.
	 *
	 * @return the string
	 */
	public String vacia(){
		return this.mundo.vaciar();
	}
	
	/**
	 * Crea.
	 *
	 * @param fila the fila
	 * @param columna the columna
	 * @return the string
	 */
	public String crea(int fila, int columna){
		try {
			return this.mundo.crearCelula(fila, columna);
		} catch (IndicesFueraDeRango e) {
			System.out.println(e.toString());
		}return "";
	}
	
	/**
	 * Juega.
	 *
	 * @param mundo the mundo
	 * @return the string
	 */
	public String juega(Mundo mundo){
		this.mundo = mundo;
		return "";
	}
	
	/**
	 * Cargar.
	 *
	 * @param nomFichero the nom fichero
	 * @return the string
	 */
	public String cargar(String nomFichero){
		this.copiaAuxiliar = this.mundo;
		try {
			    this.bf = new BufferedReader(new FileReader(nomFichero));
			    this.mundo = crearMundoArchivo(bf, nomFichero);
				this.mundo.load(bf);
				this.bf.close();
		  }catch(PalabraIncorrecta e){
			  this.mundo = this.copiaAuxiliar; 
			  return e.toString();
		  }catch (ArrayIndexOutOfBoundsException | NullPointerException | IOException e){
			  this.mundo = this.copiaAuxiliar; 
			  return Textos.errorArchivo();
		  }this.copiaAuxiliar = this.mundo;
		return "";
	}

	
	/**
	 * Crear mundo archivo.
	 *
	 * @param bf the bf
	 * @param nomFichero the nom fichero
	 * @return the mundo
	 * @throws PalabraIncorrecta the palabra incorrecta
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Mundo crearMundoArchivo(BufferedReader bf, String nomFichero) throws PalabraIncorrecta, IOException{
		String cadena = null;
			cadena = bf.readLine();
			if(cadena.equalsIgnoreCase("simple")) return new MundoSimple();
			else if(cadena.equalsIgnoreCase("complejo")) return new MundoComplejo();
			else throw new PalabraIncorrecta();
	}
	/**
	 * Guardar.
	 *
	 * @param nomFichero the nom fichero
	 * @return the string
	 */
	public String guardar(String nomFichero){
		try {
			bw = new BufferedWriter(new FileWriter(nomFichero));
			this.mundo.save(bw);
			bw.close();
		} catch (NumberFormatException | IOException e){
			return Textos.errorArchivo();
		}return Textos.savegame();
	}
	
	/**
	 * Salir.
	 *
	 * @return the string
	 */
	public String salir(){
		this.simulacionTerminada = true;
		return Textos.finSimulacion();
	}
}
