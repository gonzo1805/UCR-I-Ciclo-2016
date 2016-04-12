import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Clase usada para la compresion y descompresion de los archivos
 * @author Gonzalo
 *
 */
public class Compresor_Descompresor {

	/**
	 * Metodo que comprime todo el archivo original y lo guarda en un archivo .huff 
	 * Cada parte se explicara dentro del metodo 
	 */
	public void Comprime(/*String inicio, String destino*/) {
		/**"Atributos" del metodo (que en este caso algunos terminan siendo 
		 * instancias o variables locales)
		 * Lista: la lista ordenada que se usara para la compresion
		 * Archivo: el archivo de donde se lee
		 * Frecuencias: las frecuencias especificas de cada ASCII en el texto
		 * Cantidad Entradas: la cantidad de caracteres dentro del archivo original
		 */
		ListaOrdenada lista = new ListaOrdenada();
		FileInputStream archivo = null;
		float[] frecuencias = new float[256];
		//Main main = new Main();
		int cantidadEntradas = 0;

		
		try {

			/**
			 * Crea el archivo para la lectura a partir de la direccion especificada
			 */
			archivo = new FileInputStream("C:\\Users\\b35584\\Desktop\\bla.jpg");
			//archivo = new FileInputStream("C:\\Users\\Gonzalo\\git\\UCR-I-Ciclo-2016\\Compresor Huffman\\texto.txt");
			//archivo = new FileInputStream("C:\\Users\\Gonzalo\\git\\UCR-I-Ciclo-2016\\Compresor Huffman\\Untitled.jpg");
			/**
			 * While para la lectura del archivo y 
			 */
			int i;
			while (archivo.available() != 0) {
				i = archivo.read();
				frecuencias[i]++;
				cantidadEntradas++;
			}

			/**
			 * For para la creacion de las frecuencias y la lista 
			 */
			for (int o = 0; o < 255; o++) {
				if (frecuencias[o] / cantidadEntradas != 0) {
					ArbolBinario arbol = new ArbolBinario((frecuencias[o] / cantidadEntradas), o);
					lista.insertarArbol(arbol);
				}
			}
			archivo.close();//cierre del archivo
			/**
			 * Metodo depurador del codigo
			 */
			//lista.imprimaLista();
			
			/**
			 * Generamos el arbol a partir de la lista
			 * y lo obtenemos por separado de los nodos
			 */
			lista.generaArbol(lista);
			ArbolBinario arbol = new ArbolBinario();
			arbol = arbol.getArbolEntero(lista.getCabeza());
			/**
			 * Metodo depurador del codigo
			 */
			//arbol.imprima();
			/**
			 * Creacion de la tabla y se rellena con los codigos 
			 */
			TablaCodigos tablaHuff = new TablaCodigos();
			arbol.obtieneCodigosHuffman(tablaHuff, arbol);
			/**
			 * Metodo depurador del codigo
			 */
			//tablaHuff.imprimaTabla();
			
			/**
			 * Reapertura del archivo para la compresion
			 */
			archivo = new FileInputStream("C:\\User\\b35584\\Desktop\\bla.jpg");
			//archivo = new FileInputStream("C:\\Users\\Gonzalo\\git\\UCR-I-Ciclo-2016\\Compresor Huffman\\texto.txt");
			//archivo = new FileInputStream("C:\\Users\\Gonzalo\\git\\UCR-I-Ciclo-2016\\Compresor Huffman\\Untitled.jpg");

			/**
			 * archivo2 es el archivo que se va a guardar out el que nos habilita al uso de bits
			 */
			FileOutputStream archivo2 = new FileOutputStream("C:\\Users\\b35584\\Desktop\\troll.huf");
			//FileOutputStream archivo2 = new FileOutputStream("C:\\Users\\Gonzalo\\Desktop\\troll.huf");
			BitOutputStream out = new BitOutputStream(archivo2);
			
			/**
			 * Se escribe huf al inicio del archivo para identificar un archivo comprimido por 
			 * este compresor
			 */
			out.write(104);//"h"
			out.write(117);//"u"
			out.write(102);//"f"
			/**
			 * El algoritmo de compresion se uso de la siguiente manera.
			 * Primero los 3 caracteres clave para saber si el archivo fue comprimido por uno, 
			 * seguido de la cantidad de caracteres diferentes en el archivo.
			 * Luego se insertaron un caracter continuo al largo del codigo de compresion de ese caracter.
			 * Seguido vienen todos los codigos de compresion continuos uno del otro sin ninguna separacion 
			 * y luego tambien sin ninguna separacion viene todo el archivo comprimido que se leyo del original
			 */
			int cantidadCaracteres = 0;
			for (int f = 0; f < 255; f++) {
				if (frecuencias[f] != 0) {
					cantidadCaracteres++;
				}
			}
			out.write(cantidadCaracteres);
			
			for (int f = 0; f < 255; f++) {
				if (frecuencias[f] != 0) {
					out.write(f);
					/**
					 * int d usado para depuracion
					 */
					//int d = tablaHuff.tamanoCodigo(f);
					out.write(tablaHuff.tamanoCodigo(f));
					/**
					 * el string usado para depuracion
					 */
					//String a = tablaHuff.getCodigo(f);
					//System.out.println(a);
				}
			}
			
			
			for (int f = 0; f < 255; f++) {
				if (frecuencias[f] != 0) {
					/**
					 * String usado para depuracion
					 */
					//String a = tablaHuff.getCodigo(f);
					out.writeBits(tablaHuff.getCodigo(f));

					
				}
			}
			/**
			 * While para la compresion del archivo
			 */
			while (archivo.available() != 0) {
				i = archivo.read();
				out.writeBits(tablaHuff.getCodigo(i));
			}
			archivo.close();//Cierre de archivo
			out.close();//Cierre de out
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}//Fin de la compresion
	
	/**
	 * Metodo que descomprime un archivo previamente comprimido por este compresor, 
	 * se especificara cada parte dentro del metodo.
	 */
	public void Descomprime(/*String inicio, String destino*/) {
		
		/**"Atributos" del metodo (que en este caso algunos terminan siendo 
		 * instancias o variables locales)
		 * Tabla: la tabla que se usa para la implementacion del algoritmo de descompresion
		 * Archivo: el archivo previamente comprimido del cual se recreara el original
		 */
		FileInputStream archivo = null;
		TablaCodigos tabla = new TablaCodigos();

		try {
			/**
			 * Apertura del archivo previamente comprimido y creacion de in
			 * que nos permite la lectura por bits del mismo
			 */
			archivo = new FileInputStream("C:\\Users\\b35584\\Desktop\\troll.huf");
			//archivo = new FileInputStream("C:\\Users\\Gonzalo\\Desktop\\troll.huf");
			BitInputStream in = new BitInputStream(archivo);

			/**
			 * Comprobacion de los 3 primeros caracteres del archivo sean huf para saber
			 * que fue previamente comprimido por este programa, si no lo son se escribe en pantalla
			 * y se cierra el archivo y termina el metodo
			 */
			if (in.read() != 104) {
				System.out.println(
						"Este archivo no fue comprimido por el compresor, no se puede descifrar su contenido, favor ingrese un archivo previamente comprimido por este programa");
				archivo.close();
				in.close();
				return;
			}
			if (in.read() != 117) {
				System.out.println(
						"Este archivo no fue comprimido por el compresor, no se puede descifrar su contenido, favor ingrese un archivo previamente comprimido por este programa");
				archivo.close();
				in.close();
				return;
			}
			if (in.read() != 102) {
				System.out.println(
						"Este archivo no fue comprimido por el compresor, no se puede descifrar su contenido, favor ingrese un archivo previamente comprimido por este programa");
				archivo.close();
				in.close();
				return;
			}
			/**
			 * Se sacan la cantidad de caracteres para la lectura exacta del codigo para evitar falsos bits
			 */
			int cantidadCaracteres = in.read();
			/**
			 * Print para depuracion
			 */
			//System.out.println(cantidadCaracteres);

			/**
			 * Creacion del codigo y el arbol para empezar a almacenar los codigos
			 */
			ArbolBinario raiz = new ArbolBinario();
			ArbolBinario auxiliar = raiz;
			int aux = cantidadCaracteres;
			String codigo = "";
			
			/**
			 * Lee e inserta en el arbol el ASCII con su respectivo tamaño del codigo
			 * mas no el codigo en si aun
			 */
			while (aux != 0) {
				int dato = in.read();
				int tamanoCodigo = in.read();
				tabla.inserteDato(dato, "", tamanoCodigo);
				aux--;
			}
			
			/**
			 * Lee los codigos respectivos para cada ASCII consultando la tabla para el tamaño del codigo
			 * luego los asigna a cada ASCII en la tabla
			 */
			for (int t = 0; t < 255; t++) {
				if (tabla.existe(t) == true) {
					int tamano = tabla.getTamano(t);
					while (tamano != 0) {
						codigo += in.readBit();
						tamano--;
					}
					tabla.setHuff(t, codigo);
					codigo = "";
				}
			}
			
			/**
			 * Crea el ArbolBinario que contendra la estructura exacta con la que se comprimio el archivo
			 * para poder permitir la descompresion del archivo, todo a partir de los codigos conseguidos en el paso anterior.
			 * Todo con la condicional de que el ASCII existe en la tabla, si no lo busca
			 */
			for (int u = 0; u < 255; u++) {
				if (tabla.existe(u) == true) {
					ArbolBinario insercion = new ArbolBinario(0, u);
					for (int a = 0; a <= tabla.getCodigo(u).length(); a++) {
						if (a == tabla.getCodigo(u).length() - 1) {
							String b = Character.toString(tabla.getCodigo(u).charAt(a));
							if (Integer.parseInt(b) == 0) {
								auxiliar.setHijoIzquierdo(insercion);
								break;
							}
							b = Character.toString(tabla.getCodigo(u).charAt(a));
							if (Integer.parseInt(b) == 1) {
								auxiliar.setHijoDerecho(insercion);
								break;
							}
						}
						String b = Character.toString(tabla.getCodigo(u).charAt(a));
						if (Integer.parseInt(b) == 1) {
							if (auxiliar.getHijoDerecho() == null) {
								auxiliar.creaHijoDerecho();
								auxiliar = auxiliar.getHijoDerecho();
							} else if (auxiliar.getHijoDerecho() != null) {
								auxiliar = auxiliar.getHijoDerecho();
							}
						}
						b = Character.toString(tabla.getCodigo(u).charAt(a));
						if (Integer.parseInt(b) == 0) {
							if (auxiliar.getHijoIzquierdo() == null) {
								auxiliar.creaHijoIzquierdo();
								auxiliar = auxiliar.getHijoIzquierdo();
							} else if (auxiliar.getHijoIzquierdo() != null) {
								auxiliar = auxiliar.getHijoIzquierdo();
							}
						}
					}
					auxiliar = raiz;
					aux--;
					codigo = "";
				}
			}
			/**
			 * Print para depuracion
			 */
			//raiz.imprimaArbol();
			
			/**
			 * Apertura del nuevo archivo donde sera almacenado o escrito el nuevo archivo esta vez ya descomprimido
			 */
			FileOutputStream escritura = new FileOutputStream("C:\\User\\b35584\\Desktop\\descom.jpg");
			//FileOutputStream escritura = new FileOutputStream("C:\\Users\\Gonzalo\\Desktop\\trollDescom.txt");
			//FileOutputStream escritura = new FileOutputStream("C:\\Users\\Gonzalo\\Desktop\\imgDescom.jpg");
			BitOutputStream out = new BitOutputStream(escritura);
			
			/**
			 * Un auxiliar para no dañar la raiz del arbol
			 */
			auxiliar = raiz;
			
			/**
			 * Algoritmo de la descompresion del archivo, lee bit por bit y al mismo tiempo buscando 
			 * en el ArbolBinario para buscar una hoja, cuando la encuentra escribe el ASCII en el archivo
			 * nuevo y vuelve a empezar todo hecho mientras tenga algo que leer
			 */
			while (in.available() != 0) {
				if (auxiliar.getHijoDerecho() == null && auxiliar.getHijoIzquierdo() == null) {
					out.write(auxiliar.getASCII());
					auxiliar = raiz;
				}
				int b = in.readBit();//Lectura del bit para el camino del arbol
				if (b == 0) {

					auxiliar = auxiliar.getHijoIzquierdo();

				} else if (b == 1) {

					auxiliar = auxiliar.getHijoDerecho();

				}
			}
			
			out.close();//Cierre del out
			in.close();//Cierre del in

		} catch (

		Exception ex) {
			ex.printStackTrace();
		}
	}//Fin de la descompresion
}//Fin de la clase
