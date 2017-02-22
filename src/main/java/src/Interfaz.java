import javax.swing.JOptionPane;

/**
 * Clase encargada de contruir y mostrar la interfaz de la aplicaci�n.
 * @author Miguel �ngel Quintero 
 * @version 21/02/2017
 */
public class Interfaz {
	/**
	 * M�todo main, encargado de instanciar la clase contador, recibe la ruta del directorio a analizar y se 
	 * lo pasa como p�rametro al m�todo inicializar. De ser correcta la ruta, muestra en pantalla el resultado 
	 * del an�lisis.
	 * @param args
	 */
	public static void main(String[] args) {//Declaracion metodo 
		
		Contador c = new Contador();
		String ruta = JOptionPane.showInputDialog("Ingrese la ruta del archivo");
		if (ruta == null) {
			System.exit(0);
		}
		c.inicializar(ruta);
		String [][] resultados = c.devolverResultados();
		int lineasTotales = c.devolverLineasTotales();
		
		for (int i = 0; i < resultados.length; i++) {
			System.out.println("Clase: " + resultados[i][0] + " - N�mero partes : " + resultados[i][1] + " - Cantidad l�neas: " + resultados[i][2] + "\n");
		}
		
		System.out.print("Lineas totales: " + lineasTotales);
	}
	/**Fin del m�todo**/
}
