/*
 * 
 */
package gameOfLife.Comando;

import gameOfLife.Excepciones.ErrorDeInicializacion;
import gameOfLife.Excepciones.FormatoNumericoIncorrecto;
import gameOfLife.Excepciones.IndicesFueraDeRango;

// TODO: Auto-generated Javadoc
/**
 * The Class ParserComando.
 */
public class ParserComando {
	
	/** The comandos. */
	public static Comando[] comandos = {new ComandoAyuda(),
										new ComandoSalir(),
										new ComandoCrear(0,0),
										new ComandoEliminar(0,0),
										new ComandoIniciar(),
										new ComandoPaso(),
										new ComandoVaciar(),
										new ComandoJugar(0,0,0),
										new ComandoCargar(null),
										new ComandoGuardar(null)
										};
	
	/**
	 * Devuelve un string, con la ayuda de todos los comandos.
	 *
	 * @return the string
	 */
	static public String AyudaComandos(){
		StringBuilder ayuda = new StringBuilder();
		
		for(int i = 0; i < comandos.length; i++)
			ayuda.append(comandos[i].textoAyuda());
		return ayuda.toString();
	}
	
	/**
	 * Recorre todos los comandos hasta que alguno coincida con el dado, si no existe devuelve null.
	 *
	 * @param cadenas the cadenas
	 * @return the comando
	 * @throws FormatoNumericoIncorrecto the formato numerico incorrecto
	 * @throws ErrorDeInicializacion the error de inicializacion
	 * @throws IndicesFueraDeRango the indices fuera de rango
	 */
	static public Comando parseaComando(String[] cadenas)throws FormatoNumericoIncorrecto, ErrorDeInicializacion, IndicesFueraDeRango {
		Comando com = null;
		int i = 0;
		while(i < comandos.length && com == null){
			com = comandos[i].parsea(cadenas);
			i++;
		}
		return com;
	}
}