/**
 * Estructura de datos usada para el almacenamiento de todos los Caracteres con
 * sus respectivas frecuencias y c�digos de Huff. Además, también se utiliza
 * para la descompresi�n en la creaci�n del arbol para conseguir los
 * caracteres al momento de la lectura del comprimido
 *
 * @author Gonzalo
 */
public class ArbolBinario {

	/**
	 * Atributos de la clase Frecuencia: la frecuencia del ASCII en el texto
	 * original ASCII: el valor ASCII de la letra en el texto original y en el
	 * arbol de descompresion HijoDerecho: hijo derecho del arbol HijoIzquierdo:
	 * hijo izquierdo del arbol
	 */
	private float frecuencia;
	private int ASCII;
	private ArbolBinario hijoDerecho = null;
	private ArbolBinario hijoIzquierdo = null;

	/**
	 * Retorna el ASCII del ArbolBinario al que se esta apuntando
	 *
	 * @return el ASCII del ArbolBinario al que se esta apuntando
	 */
	public int getASCII() {
		return this.ASCII;
	}//Fin del getASCII

	/**
	 * Asigna el valor ASCII mandado por parametro al ArbolBinario que se esta
	 * apuntando
	 *
	 * @param ASCII
	 *            valor a asignar en el ArbolBinario al que se esta apuntando
	 */
	public void setASCII(int ASCII) {
		this.ASCII = ASCII;
	}//Fin del setASCII

	/**
	 * Asigna el valor de la frecuencia mandado por parametro al ArbolBinario
	 * que se esta apuntando
	 *
	 * @param frecuencia
	 *            valor a asignar en el ArbolBinario al que se esta apuntando
	 */
	public void setFrecuencia(float frecuencia) {
		this.frecuencia = frecuencia;
	}//Fin del setFrecuencia

	/**
	 * Retorna la frecuencia en el ArbolBinario que se esta apuntando
	 *
	 * @return la frecuencia en el ArbolBinario que se esta apuntando
	 */
	public float getFrecuencia() {
		return this.frecuencia;
	}//Fin del getFrencuencia

	/**
	 * Retorna el hijo derecho del ArbolBinario que se esta apuntando
	 *
	 * @return el hijo derecho del ArbolBinario que se esta apuntando
	 */
	public ArbolBinario getHijoDerecho() {
		return this.hijoDerecho;
	}//Fin del getHijoDerecho

	/**
	 * Retorna el hijo izquierdo del ArbolBinario que se esta apuntando
	 *
	 * @return el hijo izquierdo del ArbolBinario que se esta apuntando
	 */
	public ArbolBinario getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}//Fin del getHijoIzquierdo

	/**
	 * Asinga al hijo izquierdo del ArbolBinario que se apunta el hijo mandado
	 * por parametro
	 *
	 * @param hijo
	 *            ArbolBinario que sera el hijo izquierdo del ArbolBinario que
	 *            se apunta
	 */
	public void setHijoIzquierdo(ArbolBinario hijo) {
		this.hijoIzquierdo = hijo;
	}//Fin del setHijoIzquierdo

	/**
	 * Asinga al hijo derecho del ArbolBinario que se apunta el hijo mandado por
	 * parametro
	 *
	 * @param hijo
	 *            ArbolBinario que sera el hijo derecho del ArbolBinario que se
	 *            apunta
	 */
	public void setHijoDerecho(ArbolBinario hijo) {
		this.hijoDerecho = hijo;
	}//Fin del setHijoDerecho

	/**
	 * Metodo usado en la descompresion del archivo, crea un hijo izquierdo al
	 * ArbolBinario que se esta apuntando
	 */
	public void creaHijoIzquierdo() {
		this.hijoIzquierdo = new ArbolBinario();
	}//Fin del creaHijoIzquierdo

	/**
	 * Metodo usado en la descompresion del archivo, crea un hijo derecho al
	 * ArbolBinario que se esta apuntando
	 */
	public void creaHijoDerecho() {
		this.hijoDerecho = new ArbolBinario();
	}//Fin del creaHijoDerecho

	/**
	 * Constructor ArbolBinario
	 */
	public ArbolBinario() {

	}//Fin ArbolBinario

	/**
	 * Constructor por parametros de ArbolBinario
	 * 
	 * @param frecuencia
	 *            valor de la frecuencia del ASCII en el texto
	 * @param ASCII
	 *            letra especifica del texto
	 */
	public ArbolBinario(float frecuencia, int ASCII) {
		this.frecuencia = frecuencia;
		this.ASCII = ASCII;
	}//Fin ArbolBinario

	/**
	 * Un get para obtener solamente el ArbolBinario que esta dentro del nodo
	 * 
	 * @param raiz
	 *            Nodo enviado por parametro que contiene el ArbolBinario
	 * @return el ArbolBinario dentro del nodo
	 */
	public ArbolBinario getArbolEntero(Nodo raiz) {
		return raiz.getValor();
	}//Fin getArbolEntero

	/**
	 * Llamamiento del recursivo para la impresion
	 */
	public void imprima() {
		this.imprimaArbol();
	}//Fin imprima

	/**
	 * Metodo recursivo para la impresion del arbol, va in-orden e imprime en el
	 * nodo en el que esta al momento
	 */
	public void imprimaArbol() {

		if (this.hijoIzquierdo != null) {

			this.hijoIzquierdo.imprima();
		}
		System.out.println(frecuencia + " " + (char) ASCII + " ");
		if (this.hijoDerecho != null) {

			this.hijoDerecho.imprima();
		}

	}//Fin imprimaArbol

	/**
	 * Constructor para ArbolBinario a partir de 2 arboles enviados por
	 * parametro, suma sus frecuencias y asigna los arboles enviados por
	 * parametros como hijos del nuevo arbol. En este caso por motivos de
	 * implementacion no se le hizo un condicional para el orden de los hijos,
	 * ya que siempre se mandaba el mas peque�o como arbol_1 y el mayor como
	 * arbol_2, en caso de ser iguales el mismo orden implementado en la lista
	 * lo resolvia. Todos los terminos de mayor o menor vienen dados por la
	 * frecuencia
	 * 
	 * @param arbol_1
	 *            arbol enviado como el mas bajo entre los dos
	 * @param arbol_2
	 *            arbol enviado como el mayor entre los dos
	 */
	public ArbolBinario(ArbolBinario arbol_1, ArbolBinario arbol_2) {

		this.frecuencia = arbol_1.getFrecuencia() + arbol_2.getFrecuencia();

		this.hijoIzquierdo = arbol_1;
		this.hijoDerecho = arbol_2;
	}//Fin ArbolBinario

	/**
	 * Metodo que llama al recursivo de obtieneCodigosHuffman
	 * 
	 * @param tabla
	 *            la tabla de codigos para la compresion
	 * @param arbol
	 *            la raiz del arbol donde se encuentran los ASCII
	 */
	public void obtieneCodigosHuffman(TablaCodigos tabla, ArbolBinario arbol) {
		String codigo = "";
		obtieneCodigosHuffman(tabla, arbol, codigo);
	}//Fin obtieneCodigosHuffman

	/**
	 * Metodo que recorre el arbol de manera recursiva, buscando hojas dentro
	 * del mismo y creando los codigos para luego ser asignados a cada uno en la
	 * respectiva tabla
	 * 
	 * @param tabla
	 *            la tabla que contendra todos los codigos con una llave que es
	 *            el ASCII
	 * @param arbol
	 *            en este caso es el ArbolBinario en el que se encuentra el
	 *            apuntador
	 * @param codigo
	 *            es el codigo que se va formando con el recorrido del arbol y
	 *            se inserta en la tabla al encontrar una hoja
	 */
	public void obtieneCodigosHuffman(TablaCodigos tabla, ArbolBinario arbol, String codigo) {

		if (arbol.hijoIzquierdo != null && arbol.hijoDerecho != null) {

			ArbolBinario hijoIzquierdo = arbol.getHijoIzquierdo();
			ArbolBinario hijoDerecho = arbol.getHijoDerecho();

			codigo += "0";
			obtieneCodigosHuffman(tabla, hijoIzquierdo, codigo);
			codigo = codigo.substring(0, codigo.length() - 1);

			codigo += "1";
			obtieneCodigosHuffman(tabla, hijoDerecho, codigo);
			codigo = codigo.substring(0, codigo.length() - 1);

		} else if (arbol.hijoIzquierdo != null && arbol.hijoDerecho == null) {
			ArbolBinario hijoIzquierdo = arbol.hijoIzquierdo;

			codigo += "0";
			obtieneCodigosHuffman(tabla, hijoIzquierdo, codigo);
			codigo = codigo.substring(0, codigo.length() - 1);
		} else if (arbol.hijoIzquierdo == null && arbol.hijoDerecho != null) {
			ArbolBinario hijoDerecho = arbol.hijoDerecho;

			codigo += "1";
			obtieneCodigosHuffman(tabla, hijoDerecho, codigo);
			codigo = codigo.substring(0, codigo.length() - 1);
		} else if (arbol.hijoIzquierdo == null && arbol.hijoDerecho == null) {
			tabla.inserteDato(arbol.ASCII, codigo);
		}
	}//Fin obtieneCodigosHuffman

}//Fin clase
