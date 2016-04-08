import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	ListaOrdenada lista = new ListaOrdenada();

	public static void main(String[] args) {

		ListaOrdenada lista = new ListaOrdenada();
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
			
			FileOutputStream archivo2 = new FileOutputStream("C:\\Users\\Gonzalo\\Desktop\\troll.txt");
			BitOutputStream out = new BitOutputStream(archivo2);
			
			
			while (archivo.available() != 0){
				i = archivo.read();
				out.writeBit(tablaHuff.getCodigo(i));
			}
			// System.out.println(frecuencias[65]);
			// System.out.println(archivo.available());
			// System.out.println(cantidadEntradas);

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	

	public void creaEInsertaNodos(float[] frecuencias, float cantidadEntradas) {
		for (int i = 0; i <= 255; i++) {
			if (frecuencias[i] / cantidadEntradas != 0) {
				ArbolBinario arbol = new ArbolBinario((frecuencias[i] / cantidadEntradas), i);
				Nodo nodo = new Nodo(arbol);
				lista.insertarNodo(nodo);
			}
		}
	}

}
