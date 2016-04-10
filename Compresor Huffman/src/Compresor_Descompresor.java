import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Compresor_Descompresor {

	public void Comprime() {
		ListaOrdenada lista = new ListaOrdenada();
		FileInputStream archivo = null;
		float[] frecuencias = new float[256];
		Main main = new Main();
		int cantidadEntradas = 0;

		try {

			archivo = new FileInputStream("C:\\Users\\Gonzalo\\git\\UCR-I-Ciclo-2016\\Compresor Huffman\\texto.txt");
			//BitInputStream in = new BitInputStream(archivo);
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
			//in = new BitInputStream (archivo);

			/**
			 * archivo2 es el archivo que se va a guardar out
			 */
			FileOutputStream archivo2 = new FileOutputStream("C:\\Users\\Gonzalo\\Desktop\\troll.gonzalo");
			BitOutputStream out = new BitOutputStream(archivo2);

			out.write(104);
			out.write(117);
			out.write(102);
			int cantidadCaracteres = 0;
			for (int f = 0; f <= 255; f++) {
					if (frecuencias[f] != 0){
						cantidadCaracteres++;
					}
			}
			out.write(cantidadCaracteres);
			
			
			for (int f = 0; f <= 255; f++) {
				if (frecuencias[f] != 0) {
					out.write(f);
					out.write(tablaHuff.tama�oCodigo(f));
					out.write(Integer.parseInt(tablaHuff.getCodigo(f)));
					System.out.println("El codigo de " + f + " es " + tablaHuff.getCodigo(f));
				}
			}
			out.write(13);
			out.write(13);

			//archivo = new FileInputStream("C:\\Users\\Gonzalo\\Desktop\\troll.gonzalo");
			//in = new BitInputStream ( new FileInputStream("C:\\Users\\Gonzalo\\Desktop\\troll.gonzalo"));
			/**
			 * While para la compresion del archivo
			 */
			while (archivo.available() != 0) {
				i = archivo.read();
				out.writeBits(tablaHuff.getCodigo(i));
			}
			
			archivo = new FileInputStream("C:\\Users\\Gonzalo\\Desktop\\troll.gonzalo");
			System.out.println(archivo.read());
			System.out.println(archivo.read());
			System.out.println(archivo.read());
			System.out.println(archivo.read());
			System.out.println(archivo.read());
			archivo.close();

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void Descomprime() {
		ListaOrdenada lista = new ListaOrdenada();
		FileInputStream archivo = null;
		float[] frecuencias = new float[256];
		Main main = new Main();
		int cantidadEntradas = 0;

		try {
			archivo = new FileInputStream("C:\\Users\\Gonzalo\\Desktop\\troll.gonzalo");
			BitInputStream in = new BitInputStream (archivo);
			
			if (in.read() != 104) {
				System.out.println(
						"Este archivo no fue comprimido por el compresor, no se puede descifrar su contenido, favor ingrese un archivo previamente comprimido por este programa");
				return;
			}
			if (in.read() != 117) {
				System.out.println(
						"Este archivo no fue comprimido por el compresor, no se puede descifrar su contenido, favor ingrese un archivo previamente comprimido por este programa");
				return;
			}
			if (in.read() != 102) {
				System.out.println(
						"Este archivo no fue comprimido por el compresor, no se puede descifrar su contenido, favor ingrese un archivo previamente comprimido por este programa");
				return;
			}
			int cantidadCaracteres = in.read();
			System.out.println(cantidadCaracteres);
			
			
			ArbolBinario raiz = new ArbolBinario();
			//ArbolBinario raiz = arbol;
			ArbolBinario auxiliar = raiz;
			int aux = cantidadCaracteres;
			while (aux != 0){
				int dato = in.read();
				int tama�oCodigo = in.read();
				String codigo = "";
				while (tama�oCodigo != 0){
					codigo += Integer.toString(in.readBit());
					tama�oCodigo--;
				}
				ArbolBinario insercion = new ArbolBinario (0, dato);
				for (int a=0; a<codigo.length(); a++){
					if (a == codigo.length()-1){
						String b = codigo.substring(a, a+1);
						if (Integer.parseInt(b) == 0){
							auxiliar.setHijoIzquierdo(insercion);
							break;
						}
						b = codigo.substring(a, a+1);
						if (Integer.parseInt(b) == 1){
							auxiliar.setHijoDerecho(insercion);
							break;
						}
					}
					String b = codigo.substring(a, a+1);
					if (Integer.parseInt(b) == 1){
						if (auxiliar.getHijoDerecho() == null){
							auxiliar.creaHijoDerecho();
							auxiliar = auxiliar.getHijoDerecho();
						}
						else if (auxiliar.getHijoDerecho() != null){
							auxiliar = auxiliar.getHijoDerecho();
						}
					}
					b = codigo.substring(a, a+1);
					if (Integer.parseInt(b) == 0){
						if (auxiliar.getHijoIzquierdo() == null){
							auxiliar.creaHijoIzquierdo();
							auxiliar = auxiliar.getHijoIzquierdo();
						}
						else if (auxiliar.getHijoIzquierdo() != null){
							auxiliar = auxiliar.getHijoIzquierdo();
						}
					}
				}
				auxiliar = raiz;
				aux--;
				codigo = "";
			}
			raiz.imprimaArbol();
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
