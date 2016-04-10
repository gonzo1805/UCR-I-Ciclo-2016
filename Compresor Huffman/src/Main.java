import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	//ListaOrdenada lista = new ListaOrdenada();

	public static void main(String[] args) {
		
		Compresor_Descompresor accion = new Compresor_Descompresor();
		accion.Comprime();
		accion.Descomprime();
		
		/*ListaOrdenada lista = new ListaOrdenada();
		FileInputStream archivo = null;
		float[] frecuencias = new float[256];
		Main main = new Main();
		int cantidadEntradas = 0;

		try {

			archivo = new FileInputStream("C:\\Users\\Gonzalo\\git\\UCR-I-Ciclo-2016\\Compresor Huffman\\texto.txt");
			int i;

			while (archivo.available() != 0) {
				i = archivo.read();
				frecuencias[i]++;
				cantidadEntradas++;
			}

			for (int o = 0; o <= 255; o++) {
				if (frecuencias[o] / cantidadEntradas != 0) {
					ArbolBinario arbol = new ArbolBinario((frecuencias[o] / cantidadEntradas), o);
					lista.insertarArbol(arbol);
				}
			}
			archivo.close();
			lista.imprimaLista();
			// main.creaEInsertaNodos(frecuencias, cantidadEntradas);
			// (nodo.getValor()).imprima();
			lista.generaArbol(lista);
			ArbolBinario arbol = new ArbolBinario();
			arbol = arbol.getArbolEntero(lista.getRaiz());
			arbol.imprima();
			TablaCodigos tablaHuff = new TablaCodigos();
			arbol.obtieneCodigosHuffman(tablaHuff, arbol);
			tablaHuff.imprimaTabla();

			archivo = new FileInputStream("C:\\Users\\Gonzalo\\git\\UCR-I-Ciclo-2016\\Compresor Huffman\\texto.txt");
			
			/**
			 * archivo2 es el archivo que se va a guardar 
			 * out 
			 */
			/*FileOutputStream archivo2 = new FileOutputStream("C:\\Users\\Gonzalo\\Desktop\\troll.gonzalo");
			BitOutputStream out = new BitOutputStream(archivo2);
			
			/**
			 * While para la compresion del archivo
			 */
			/*while (archivo.available() != 0) {
				i = archivo.read();
				String codigo = tablaHuff.getCodigo(i);
				out.writeBits(tablaHuff.getCodigo(i));
			}

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}*/

	/*public void creaEInsertaNodos(float[] frecuencias, float cantidadEntradas) {
		for (int i = 0; i <= 255; i++) {
			if (frecuencias[i] / cantidadEntradas != 0) {
				ArbolBinario arbol = new ArbolBinario((frecuencias[i] / cantidadEntradas), i);
				Nodo nodo = new Nodo(arbol);
				lista.insertarNodo(nodo);
			}
		}
	}*/

}
}