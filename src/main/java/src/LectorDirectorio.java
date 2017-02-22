import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 * Clase encargada de analizar el directorio ingresado y devolver las rutas de los archivos .java, los nombres de las 
 * clases y las líneas de los archivos .java.
 * @author Miguel Ángel Quintero
 * @version 21/02/2017
 */
public class LectorDirectorio {
	
	/**Variables de la clase**/
	private LinkedList listaArchivos = new LinkedList();
	private LinkedList archivo = new LinkedList();
	private LinkedList clases = new LinkedList();
	
	/**
	 * Analiza el directorio cuya ruta está dada por el parametro de entrada, y almacena la dirección de las rutas 
	 * de los archivos .java en la variable listaArchivos y los nombres de las clases en la variable archivo
	 * @param ruta Ruta del directorio a analizar
	 */
	public void leerDirectorio(String ruta){//Declaracion metodo
		
		File directorio = new File(ruta);
		File [] listaDirectorios = directorio.listFiles();
		
		try {
			for (int i = 0; i < listaDirectorios.length; i++) {
				if(listaDirectorios[i].isDirectory()){
					leerDirectorio(listaDirectorios[i].getAbsolutePath());
				}else{
					if(listaDirectorios[i].isFile()){
						if(listaDirectorios[i].getName().endsWith(".java") ){
							this.listaArchivos.add(listaDirectorios[i].getAbsolutePath());
							this.clases.add(listaDirectorios[i].getName());
						}
					}
				}
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese una ruta valida");
			System.exit(0);
		}	
	}
	/**Fin del método**/
	
	/**
	 * Lee línea a línea el archivo dado por la ruta que se pasa como parametro y almacena estas líneas en 
	 * la variable archivo
	 * @param rutaArchivo Ruta del archivo a leer
	 */
	public void leerArchivo(String rutaArchivo){//Declaracion metodo
		try {
			
			BufferedReader bf = new BufferedReader(new FileReader(rutaArchivo));
			LinkedList<String> listaTemporal = new LinkedList();
			String lineaLeida; 
			String lineaTemporal;
			
			while ((lineaLeida = bf.readLine()) != null) {
				lineaTemporal = lineaLeida;
				listaTemporal.add(lineaTemporal);				
			}
			archivo = listaTemporal;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error leyendo el archivo. Verifique que la ruta ingresada "
					+ "exista o que campo de la ruta no esté vacío");
			System.exit(0);
		}
		
		
	}
	/**Fin del método**/
	
	/**
	 * Método encargado de devolver la lista con las líneas de un archivo
	 * @return archivo Lista con las líneas de un archivo leído
	 */
	public LinkedList devolverLineasArchivo(){//Declaracion metodo
		return archivo;
	}
	/**Fin del método**/
	
	/**
	 * Devuelve la lista de las rutas de los archivos .java a leer
	 * @return listaArchivos Lista con las rutas de los archivos a leer
	 */
	public LinkedList devolverDirectorios(){//Declaracion metodo
		return listaArchivos;		
	}
	/**Fin del método**/
	
	/**
	 * Devuelve la lista de clases del programa 
	 * @return clases Lista con las clases del programa analizado
	 */
	public LinkedList devolverClases(){//Declaracion metodo
		return clases;
	}
	/**Fin del método**/
	

}
