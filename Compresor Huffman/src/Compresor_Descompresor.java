import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Clase usada para la compresion y descompresion de los archivos
 * 
 * @author Gonzalo
 *
 */
public class Compresor_Descompresor {

	/**
	 * Metodo que comprime todo el archivo original y lo guarda en un archivo
	 * .huff Cada parte se explicara dentro del metodo
	 */
	public void Comprime(String Inicio, String Destino) {
		/**
		 * "Atributos" del metodo (que en este caso algunos terminan siendo
		 * instancias o variables locales) Lista: la lista ordenada que se usara
		 * para la compresion Archivo: el archivo de donde se lee Frecuencias:
		 * las frecuencias especificas de cada ASCII en el texto Cantidad
		 * Entradas: la cantidad de caracteres dentro del archivo original
		 */
		ListaOrdenada lista = new ListaOrdenada();
		FileInputStream archivo = null;
		float[] frecuencias = new float[256];
		// Main main = new Main();
		int cantidadEntradas = 0;

		try {

			/**
			 * Crea el archivo para la lectura a partir de la direccion
			 * especificada
			 */
			archivo = new FileInputStream(Inicio);
			/**
			 * While para la lectura del archivo y
			 */
			int i;
			while (archivo.available() != 0) {//Mientras no sea null
				i = archivo.read();
				frecuencias[i]++;
				cantidadEntradas++;
			}

			/**
			 * For para la creacion de las frecuencias y la lista
			 */
			for (int o = 0; o < 256; o++) {
				if (frecuencias[o] / cantidadEntradas != 0) {
					ArbolBinario arbol = new ArbolBinario((frecuencias[o] / cantidadEntradas), o);
					lista.insertarArbol(arbol);
				}
			}
			archivo.close();// cierre del archivo
			/**
			 * Metodo depurador del codigo
			 */
			// lista.imprimaLista();

			/**
			 * Generamos el arbol a partir de la lista y lo obtenemos por
			 * separado de los nodos
			 */
			lista.generaArbol(lista);
			ArbolBinario arbol = new ArbolBinario();
			arbol = arbol.getArbolEntero(lista.getCabeza());
			/**
			 * Metodo depurador del codigo
			 */
			// arbol.imprima();
			/**
			 * Creacion de la tabla y se rellena con los codigos
			 */
			TablaCodigos tablaHuff = new TablaCodigos();
			arbol.obtieneCodigosHuffman(tablaHuff, arbol);
			/**
			 * Metodo depurador del codigo
			 */
			// tablaHuff.imprimaTabla();

			/**
			 * Reapertura del archivo para la compresion
			 */

			archivo = new FileInputStream(Inicio);

			/**
			 * archivo2 es el archivo que se va a guardar out el que nos
			 * habilita al uso de bits
			 */
			FileOutputStream archivo2 = new FileOutputStream(Destino);
			BitOutputStream out = new BitOutputStream(archivo2);

			/**
			 * Se escribe huf al inicio del archivo para identificar un archivo
			 * comprimido por este compresor. El metodo usado es convertir el
			 * byte correspondiente al ASCII de cada letra
			 * (Integer.toBinaryString) y usar 8 bits de manera fija, para
			 * evitar la interpretacion de los 0`s a la izquierda como datos que
			 * no deben aparecer en el bit guardado, asi una serie de bits que
			 * deberia ser 0001 no se convierte en un 1.
			 */
			out.writeBits(String.format("%8s", Integer.toBinaryString((104 + 256) % 256)).replace(' ', '0'));// "h"
			out.writeBits(String.format("%8s", Integer.toBinaryString((117 + 256) % 256)).replace(' ', '0'));// "u"
			out.writeBits(String.format("%8s", Integer.toBinaryString((102 + 256) % 256)).replace(' ', '0'));// "f"
			/**
			 * El algoritmo de compresion se uso de la siguiente manera. Primero
			 * los 3 caracteres clave para saber si el archivo fue comprimido
			 * por uno, seguido de la cantidad de caracteres diferentes en el
			 * archivo. Luego se insertaron un caracter continuo al largo del
			 * codigo de compresion de ese caracter. Seguido vienen todos los
			 * codigos de compresion continuos uno del otro sin ninguna
			 * separacion y luego tambien sin ninguna separacion viene todo el
			 * archivo comprimido que se leyo del original
			 */
			int cantidadCaracteres = 0;
			for (int f = 0; f < 256; f++) {
				if (frecuencias[f] != 0) {
					cantidadCaracteres++;
				}
			}
			// Aqui como el numero maximo para un numero de 8 bits es 255, si
			// hay 256 caracteres este se inserta como un 0, dando un falso
			// positivo en caso
			// de haber 0 caracteres en el archivo, cosa que no puede ser en
			// casi todos los casos por lo que el bug se considero despreciable.
			// En todas las inserciones en el texto se uso este formato para
			// generar datos de 8 bits y no tener perdida de datos
			if (cantidadCaracteres == 256) {
				out.writeBits(String.format("%8s", Integer.toBinaryString((256 + 256) % 256)).replace(' ', '0'));
			} else {
				out.writeBits(String.format("%8s", Integer.toBinaryString((cantidadCaracteres + 256) % 256))
						.replace(' ', '0'));
			}
			/**
			 * Metodo depurador del proyecto
			 */
			// System.out.print(String.format("%8s", Integer.toBinaryString((256
			// + 256) % 256)).replace(' ', '0'));

			for (int f = 0; f < 256; f++) {
				if (frecuencias[f] != 0) {
					// Mismo formato en todas las inserciones
					out.writeBits(String.format("%8s", Integer.toBinaryString((f + 256) % 256)).replace(' ', '0'));// Insercion de la letra
					/**
					 * int d usado para depuracion
					 */
					// int d = tablaHuff.tamanoCodigo(f);
					out.writeBits(String.format("%8s", Integer.toBinaryString((tablaHuff.tamanoCodigo(f) + 256) % 256))
							.replace(' ', '0'));// Insercion del largo del
												// codigo asociado a la letra
					/**
					 * string a usado para depuracion
					 */
					// String a = tablaHuff.getCodigo(f);
					// System.out.println(a);
				}
			}

			/**
			 * Insercion de todos los codigos
			 */
			for (int f = 0; f < 256; f++) {
				if (frecuencias[f] != 0) {
					/**
					 * String usado para depuracion
					 */
					// String a = tablaHuff.getCodigo(f);
					/**
					 * Aqui no se uso el formato usado en las inserciones
					 * anteriores porque cada codigo tiene su tamaño fijo que se
					 * crea en todo el proceso por lo que no debe estar
					 * acomodado a un tamaño de 8 bits
					 */
					out.writeBits(tablaHuff.getCodigo(f));

				}
			}
			/**
			 * While para la compresion del archivo. Igual que con los codigos
			 * no se uso el formato especial de insercion ya que cada codigo
			 * tiene su tamaño predeterminado y no ocupa un relleno a 8 bits
			 */
			while (archivo.available() != 0) {
				i = archivo.read();
				out.writeBits(tablaHuff.getCodigo(i));
			}
			archivo.close();// Cierre de archivo
			out.close();// Cierre de out
		}

		// Excepciones
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}// Fin de la compresion

	/**
	 * Metodo que descomprime un archivo previamente comprimido por este
	 * compresor, se especificara cada parte dentro del metodo.
	 */
	public void Descomprime(String Inicio, String Destino) {

		/**
		 * "Atributos" del metodo (que en este caso algunos terminan siendo
		 * instancias o variables locales) Tabla: la tabla que se usa para la
		 * implementacion del algoritmo de descompresion Archivo: el archivo
		 * previamente comprimido del cual se recreara el original
		 */
		FileInputStream archivo = null;
		TablaCodigos tabla = new TablaCodigos();

		try {
			/**
			 * Apertura del archivo previamente comprimido y creacion de in que
			 * nos permite la lectura por bits del mismo
			 */
			archivo = new FileInputStream(Inicio);
			BitInputStream in = new BitInputStream(archivo);

			/**
			 * Comprobacion de los 3 primeros caracteres del archivo sean huf
			 * para saber que fue previamente comprimido por este programa, si
			 * no lo son se escribe en pantalla y se cierra el archivo y termina
			 * el metodo
			 */
			String letraEscrita = "";// Donde se guardara cada letra
			/**
			 * Aqui hacemos una iteracion de 8 bits para tomar 1 byte y
			 * reinterpretarlo a la letra
			 */
			for (int i = 0; i < 8; i++) {
				letraEscrita += in.readBit();
			}
			/**
			 * Depuracion
			 */
			// System.out.print(letraEscrita);
			/**
			 * El Integer.parseInt(letra, radix) nos permite una
			 * reinterpretacion en base 10 y con forma de int de letra, radix es
			 * la base en que esta escrito el string de bits que es letra
			 */
			if (Integer.parseInt(letraEscrita, 2) != 104) {
				System.out.println(
						"Este archivo no fue comprimido por el compresor, no se puede descifrar su contenido, favor ingrese un archivo previamente comprimido por este programa");
				archivo.close();// Cierre archivo
				in.close();// Cierre in
				return;// Fin apresurado de descomprimir
			}
			letraEscrita = "";// Reinicio de letraEscrita
			for (int i = 0; i < 8; i++) {
				letraEscrita += in.readBit();
			}
			if (Integer.parseInt(letraEscrita, 2) != 117) {
				System.out.println(
						"Este archivo no fue comprimido por el compresor, no se puede descifrar su contenido, favor ingrese un archivo previamente comprimido por este programa");
				archivo.close();// Cierre archivo
				in.close();// Cierre in
				return;// Fin apresurado de descomprimir
			}
			letraEscrita = "";// Reinicio de letraEscrita
			for (int i = 0; i < 8; i++) {
				letraEscrita += in.readBit();
			}
			if (Integer.parseInt(letraEscrita, 2) != 102) {
				System.out.println(
						"Este archivo no fue comprimido por el compresor, no se puede descifrar su contenido, favor ingrese un archivo previamente comprimido por este programa");
				archivo.close();// Cierre archivo
				in.close();// Cierre in
				return;// Fin apresurado de descomprimir
			}
			/**
			 * Se sacan la cantidad de caracteres para la lectura exacta del
			 * codigo para evitar falsos bits
			 */
			String cantidadCar = "";// Donde se guardara el numero
									// cantidadCaracteres
			for (int i = 0; i < 8; i++) {
				cantidadCar += in.readBit();
			}
			/**
			 * Depuracion
			 */
			// System.out.print(cantidadCar);
			/**
			 * Se crea el int cantidadCaracteres a partir del String que
			 * contiene los bits del numero. Aqui en el caso de que el numero
			 * sea 0 se convierte en 256 por el bug despreciable especificado en
			 * la compresion (Al no caber 256 en un byte se desfasa a 0 y se
			 * reinterpreta como 256 en la descompresion ya que un archivo no
			 * puede no tener caracteres en su archivo de compresion)
			 */
			int cantidadCaracteres = Integer.parseInt(cantidadCar, 2);
			if (cantidadCaracteres == 0)
				cantidadCaracteres = 256;

			/**
			 * Print para depuracion
			 */
			System.out.println(cantidadCaracteres);

			/**
			 * Creacion del codigo y el arbol para empezar a almacenar los
			 * codigos
			 */
			ArbolBinario raiz = new ArbolBinario();
			ArbolBinario auxiliar = raiz;
			int aux = cantidadCaracteres;
			String codigo = "";

			/**
			 * Lee e inserta en el arbol el ASCII con su respectivo tamaño del
			 * codigo mas no el codigo en si aun, e inserta en la tabla los
			 * datos que se tienen hasta el momento
			 */
			String datoEs = "";// Donde se guardaran los bits de las letras
			String tamanoCodigoEs = "";// Donde se guardaran los bits de los
										// tamaños de los codigos
			while (aux != 0) {
				for (int i = 0; i < 8; i++) {
					datoEs += in.readBit();// Los 8 bits de la letra
				}
				int dato = Integer.parseInt(datoEs, 2);// dato a partir del
														// String datoEs
				for (int i = 0; i < 8; i++) {
					tamanoCodigoEs += in.readBit();// Los 8 bits del numero del
													// tamaño del codigo
				}
				int tamanoCodigo = Integer.parseInt(tamanoCodigoEs, 2);// tamanoCodigo a partir del String tamanoCodigoEs
				tabla.inserteDato(dato, "", tamanoCodigo);
				datoEs = "";// Reinicio de datoEs
				tamanoCodigoEs = "";// Reincio de tamanoCodigoEs
				aux--;
			}

			/**
			 * Lee los codigos respectivos para cada ASCII consultando la tabla
			 * para el tamaño del codigo luego los asigna a cada ASCII en la
			 * tabla
			 */
			for (int t = 0; t < 256; t++) {
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
			 * Crea el ArbolBinario que contendra la estructura exacta con la
			 * que se comprimio el archivo para poder permitir la descompresion
			 * del archivo, todo a partir de los codigos conseguidos en el paso
			 * anterior. Todo con la condicional de que el ASCII existe en la
			 * tabla, si no lo busca
			 */
			for (int u = 0; u < 256; u++) {
				if (tabla.existe(u) == true) {
					ArbolBinario insercion = new ArbolBinario(0, u);
					for (int a = 0; a <= tabla.getCodigo(u).length(); a++) {// Mientras aun tenga codigo el codigo asignado a la letra
						if (a == tabla.getCodigo(u).length() - 1) {
							String b = Character.toString(tabla.getCodigo(u).charAt(a));// Bit en el punto del codigo por el que se va
							if (Integer.parseInt(b) == 0) {
								auxiliar.setHijoIzquierdo(insercion);// Crea el hijo con la hoja
								break;// Fin
							}
							b = Character.toString(tabla.getCodigo(u).charAt(a));// Bit en el punto del codigo por el que se va
																					 
							if (Integer.parseInt(b) == 1) {
								auxiliar.setHijoDerecho(insercion);// Crea el hijo con la hoja
								break;// Fin
							}
						}
						String b = Character.toString(tabla.getCodigo(u).charAt(a));// Bit en el punto del codigo por el que se va
						if (Integer.parseInt(b) == 1) {// Derecha
							if (auxiliar.getHijoDerecho() == null) {
								auxiliar.creaHijoDerecho();// Hijo no hoja
								auxiliar = auxiliar.getHijoDerecho();
							} else if (auxiliar.getHijoDerecho() != null) {
								auxiliar = auxiliar.getHijoDerecho();// Se mueve por el hijo ya existente
							}
						}
						b = Character.toString(tabla.getCodigo(u).charAt(a));// Bit en el punto del codigo por el que se va
						if (Integer.parseInt(b) == 0) {// Izquierda
							if (auxiliar.getHijoIzquierdo() == null) {
								auxiliar.creaHijoIzquierdo();// Hijo no hoja
								auxiliar = auxiliar.getHijoIzquierdo();
							} else if (auxiliar.getHijoIzquierdo() != null) {
								auxiliar = auxiliar.getHijoIzquierdo();// Se mueve por el hijo ya existente
							}
						}
					}
					auxiliar = raiz;// De vuelta a la raiz para la busqueda de
									// un nuevo codigo
					aux--;
					codigo = "";// Reinicio de codigo
				}
			}
			/**
			 * Print para depuracion
			 */
			// raiz.imprimaArbol();

			/**
			 * Apertura del nuevo archivo donde sera almacenado o escrito el
			 * nuevo archivo esta vez ya descomprimido
			 */
			FileOutputStream escritura = new FileOutputStream(Destino);
			BitOutputStream out = new BitOutputStream(escritura);

			/**
			 * Un auxiliar para no dañar la raiz del arbol
			 */
			auxiliar = raiz;

			/**
			 * Algoritmo de la descompresion del archivo, lee bit por bit y al
			 * mismo tiempo buscando en el ArbolBinario para buscar una hoja,
			 * cuando la encuentra escribe el ASCII en el archivo nuevo y vuelve
			 * a empezar todo hecho mientras tenga algo que leer
			 */
			while (in.available() != 0) {
				if (auxiliar.getHijoDerecho() == null && auxiliar.getHijoIzquierdo() == null) {// Caso que rompe la recursividad (Hoja)
					out.write(auxiliar.getASCII());
					auxiliar = raiz;
				}
				int b = in.readBit();// Lectura del bit para el camino del arbol
				if (b == 0) {

					auxiliar = auxiliar.getHijoIzquierdo();// Izquierda

				} else if (b == 1) {

					auxiliar = auxiliar.getHijoDerecho();// Derecha

				}
			}
			out.write(0);// Byte que finaliza el archivo, es necesario agregarlo
							// aparte ya que la lectura se cierra cuando lo lee

			out.close();// Cierre del out
			in.close();// Cierre del in

		} catch (

		//Excepciones
		Exception ex) {
			ex.printStackTrace();
		}
	}// Fin de la descompresion
}// Fin de la clase
