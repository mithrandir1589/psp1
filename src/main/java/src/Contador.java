import java.util.LinkedList;
/**
 * Clase encargada de realizar el conteo de LOC por clase y por programa. Es la encargada de comunicar la 
 * clase Interfaz y LectorDirectorio
 * @author Miguel Ángel Quintero
 * @version 21/02/2017
 */
public class Contador {
	/**Variables de la clase**/
	private LinkedList<String> archivos;
	private int cantidadLineas;
	private String [][] resultados;
	private String ruta;

	/**
	 * Método encargado de inocar el método contar y almacenar el directorio ingresado en la variable privada ruta
	 * @param ruta Ruta del directorio a analizar
	 */
	public void inicializar(String ruta){//Declaracion metodo      
		this.ruta = ruta;
		contar();
	}
	/**Fin del método**/
	
	/**
	 * Método encargado de contar la cantidad de métodos y líneas de código por programa y por clase, y almacenar 
	 * dicha información en la matriz resultados
	 */
	private void contar(){//Declaracion metodo
		
		LectorDirectorio d = new LectorDirectorio();
		d.leerDirectorio(this.ruta);
		LinkedList <String> listadoDirectorios = new LinkedList<String>();
		LinkedList <String> listadoClases = new LinkedList<String>();
		listadoDirectorios = d.devolverDirectorios();
		listadoClases = d.devolverClases();
		resultados = new String [listadoDirectorios.size()][3];
		
		for(int i = 0; i<listadoDirectorios.size();i++){
			
			resultados [i][0] = listadoClases.get(i).replace(".java", "");
			d.leerArchivo(listadoDirectorios.get(i));
			LinkedList <String> archivoTemporal = new LinkedList<String>();
			archivoTemporal = d.devolverLineasArchivo();
			int cantidadLineasTemp = 0;
			int cantidadMetodos = 0;
			
			for(int j = 0; j<archivoTemporal.size();j++){
				if(archivoTemporal.get(j).trim().startsWith("/") || archivoTemporal.get(j).trim().startsWith("*")){
					 
				}else{
					if(archivoTemporal.get(j).trim().contains(";") || archivoTemporal.get(j).trim().contains("{") || archivoTemporal.get(j).trim().contains("}") ){
						cantidadLineas++;
						cantidadLineasTemp++;
						if (archivoTemporal.get(j).trim().endsWith("Declaracion metodo")) {
							cantidadMetodos++;
						}
					}
				}
				
			}
			
			resultados [i][1] = Integer.toString(cantidadMetodos);
			resultados [i][2] = Integer.toString(cantidadLineasTemp);
			
		}
		
	}
	/**Fin del método**/
	
	/**
	 * Método encargado de devolver la cantidad de líneas totales del programa
	 * @return cantidadLineas Cantidad de líneas del programa
	 */
	public int devolverLineasTotales(){//Declaracion metodo 
		return this.cantidadLineas;
	}
	/**Fin del método**/
	
	/**
	 * Método encargado de devolver la matriz con la información de los nombres de la clase, la cantidad de métodos 
	 * y líneas de código que tiene
	 * @return resultados Información de las clases, cantidad de métodos y LOC
	 */
	public String[][] devolverResultados(){//Declaracion metodo 
		return this.resultados;
	}
	/**Fin del método**/

}
