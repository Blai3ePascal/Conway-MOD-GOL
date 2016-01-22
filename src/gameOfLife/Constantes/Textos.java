/*
 * 
 */
package gameOfLife.Constantes;

// TODO: Auto-generated Javadoc
/**
 * The Class Textos.
 */
public class Textos {
    
    /**
     * Esta clase, simplifica a la hora de buscar y modificar los textos
     * Estan ordenados en esta clase y son facilmente manipulables.
     *
     * @return the string
     */
    public static String comando(){
    	return "\nComando > ";
    }
    
    /**
     * Vaciar.
     *
     * @return the string
     */
    public static String vaciar(){
    	return "Vaciando la superficie.....\n";
    }
    
    /**
     * Crear celula.
     *
     * @param fila the fila
     * @param columna the columna
     * @return the string
     */
    public static String crearCelula(int fila, int columna){
    	return "Creamos nueva celula en la posición: ("+fila+", "+columna+")\n";
    }
    
    /**
     * Error ocupada.
     *
     * @return the string
     */
    public static String errorOcupada(){
    	return "Error, posición ocupada...\n";
    }
    
    /**
     * Eliminar posicion.
     *
     * @param fila the fila
     * @param columna the columna
     * @return the string
     */
    public static String eliminarPosicion(int fila, int columna){
    	return "Eliminando posición: ("+fila+", "+columna+")\n";
    }
    
    /**
     * Error vacio.
     *
     * @return the string
     */
    public static String errorVacio(){
    	return "Error, posición vacía...\n";
    }
    
    /**
     * Fin simulacion.
     *
     * @return the string
     */
    public static String finSimulacion(){
    	return "Fin de la simulación.....";
    }
    
    /**
     * Error no comando.
     *
     * @return the string
     */
    public static String errorNoComando(){
    	return "Error: Escriba ayuda para -Posibles comandos-\n";
    }
    
    /**
     * Apoptosis.
     *
     * @param fila the fila
     * @param columna the columna
     * @return the string
     */
    public static String apoptosis(int fila, int columna){
    	return "Muere la célula de la casilla (" + fila + ", " + columna + ") por inactividad\n";
    }
    
    /**
     * Movimiento celular.
     *
     * @param fila the fila
     * @param columna the columna
     * @param nextFila the next fila
     * @param nextColumna the next columna
     * @return the string
     */
    public static String movimientoCelular(int fila, int columna, int nextFila, int nextColumna){
    	return "Movimiento de " + "(" + fila + ", " + columna + ")"  + " a " + "("+ nextFila +", "+ nextColumna + ")\n";
    }
    
    /**
     * Nacimiento celular.
     *
     * @param fila the fila
     * @param columna the columna
     * @param nextFila the next fila
     * @param nextColumna the next columna
     * @return the string
     */
    public static String nacimientoCelular(int fila, int columna, int nextFila, int nextColumna){
    	return "Nace nueva célula en (" + fila+ ", " + columna + ") cuyo padre ha sido " + "("+ nextFila +", "+ nextColumna + ")\n";
    }
    
    /**
     * Mansion maniac.
     *
     * @param fila the fila
     * @param columna the columna
     * @return the string
     */
    public static String mansionManiac(int fila, int columna){
    	return "Muere la célula de la casilla (" + fila + ", " + columna + ") por no poder reproducirse\n"; 
    }
    
    /**
     * Imposible de jugar.
     *
     * @return the string
     */
    public static String imposibleDeJugar(){
    	return "No puedes realizar un paso en un tablero muerto...\n";
    }
    
    /**
     * Explota.
     *
     * @param fila the fila
     * @param columna the columna
     * @return the string
     */
    public static String explota(int fila, int columna){
    	return"Explota la celula compleja en ("+fila+","+columna+")\n";
    }
    
    /**
     * Comer.
     *
     * @param fila the fila
     * @param columna the columna
     * @param nf the nf
     * @param nc the nc
     * @param comida the comida
     * @return the string
     */
    public static String comer(int fila, int columna, int nf, int nc, String comida){
    	return "Célula Compleja en ("+fila + "," + columna + ") se mueve a (" + nf  + "," + nc + ") --"+comida+"COME--\n";
    }
    
    /**
     * Posiciones.
     *
     * @return the string
     */
    public static String posiciones(){
    	return "EXCEPCIÓN: Formato de numero incorrecto";
    }
    
    /**
     * Conway.
     *
     * @return the string
     */
    public static String conway(){
    	return "\n** conway's game of life **\n";
    }
    
    /**
     * Elige tipo.
     *
     * @return the string
     */
    public static String eligeTipo(){
    	return "De que tipo: Compleja (1) o Simple (2): ";
    }
    
    /**
     * No caben.
     *
     * @return the string
     */
    public static String noCaben(){
    	return "EXCEPCION: La superficie no puede abarcar ese número de células";
    }
    
    /**
     * Imposible crear nada.
     *
     * @return the string
     */
    public static String imposibleCrearNada(){
    	return "Imposible crear ninguna célula...";
    }
    
    /**
     * Error archivo.
     *
     * @return the string
     */
    public static String errorArchivo(){
    	return "EXCEPCIÓN: Fichero no encontrado o con formato no valido";
    }
    
    /**
     * Savegame.
     *
     * @return the string
     */
    public static String savegame(){
    	return "Tablero guardado...";
    }
    
    /**
     * Cargar.
     *
     * @return the string
     */
    public static String cargar(){
    	return "Tablero cargado...";
    }
    
    /**
     * Palabra incorrecta.
     *
     * @return the string
     */
    public static String palabraIncorrecta(){
    	return "EXCEPCIÓN: Palabra incorrecta";
    }
    
    /**
     * Tipo no válido.
     *
     * @return the string
     */
    public static String tipoInvalido(){
    	return "Introduce un tipo de célula válido";
    }
    
    /**
     * Fuera de rango.
     *
     * @return the string
     */
    public static String fueraDeRango(){
    	return "EXCEPCIÓN: Indices fuera de rango";
    }
    
    /**
     * Error inicializacion.
     *
     * @return the string
     */
    public static String errorInicializacion(){
    	return "EXCEPCIÓN: Error de inicializacion";
    }
}
