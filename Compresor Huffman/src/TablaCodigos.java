/**
 * Tabla contenedora de los codigos con una llave que es el ASCII, usada para la
 * compresion y descompresion del archivo
 * 
 * @author Gonzalo
 *
 */
public class TablaCodigos {

	/**
	 * Atributos de la clase Inicio: como la tabla esta implementada con listas,
	 * es la cabeza de la lista Cantidad Datos: la cantidad de entradas en la
	 * tabla ASCII: el ASCII o la letra Codigo Huff: el codigo asociado a un
	 * solo ASCII Tamaño Codigo: el tamaño del codigo de compresion (usado para
	 * la descompresion) Siguiente: como es una lista enlazada necesita un
	 * siguiente Cola: en este caso se usa un puntero a parte a la cola para
	 * facilitar el trabajo de la iteracion
	 */
	private TablaCodigos inicio;
	private static int cantidadDatos = 0;

	private int ASCII;
	private String codigoHuff;
	private int tamanoCodigo;
	private TablaCodigos siguiente = null;
	private TablaCodigos cola;

	/**
	 * Constructor de TablaCodigos
	 */
	public TablaCodigos() {
		inicio = null;
		cola = inicio;
	}//Fin tablacodigos

	/**
	 * Constructor por parametros de TablaCodigos
	 * 
	 * @param dato
	 *            el ASCII
	 * @param huff
	 *            el codigo asignado para el ASCII en la compresion y
	 *            descompresion
	 */
	public TablaCodigos(int dato, String huff) {
		this.ASCII = dato;
		this.codigoHuff = huff;
	}//Fin tablacodigos

	/**
	 * Constructor por parametros de TablaCodigos (usado para la descompresion)
	 * 
	 * @param dato
	 *            dato el ASCII
	 * @param huff
	 *            el codigo asignado para el ASCII en la compresion y
	 *            descompresion
	 * @param tamanoCodigo
	 *            el tamaño del codigo asignado a cada ASCII
	 */
	public TablaCodigos(int dato, String huff, int tamanoCodigo) {
		this.ASCII = dato;
		this.codigoHuff = huff;
		this.tamanoCodigo = tamanoCodigo;
	}//Fin tablacodigos

	/**
	 * Retorna el codigo huff del valor apuntado
	 * 
	 * @return el codigo huff del valor apuntado
	 */
	public String getHuff() {
		return this.codigoHuff;
	}//Fin gethuff

	/**
	 * Useless
	 * 
	 * @param tamano
	 */
	public void settamano(int tamano) {
		this.tamanoCodigo = tamano;
	}//Fin settamaño

	/**
	 * Asgina al dato mandado por parametro el codigo mandado por parametro,
	 * haciendo una busqueda en la tabla
	 * 
	 * @param dato
	 *            el ASCII llave
	 * @param codigo
	 *            el codigo del ASCII
	 */
	public void setHuff(int dato, String codigo) {
		TablaCodigos auxiliar = inicio;
		while (auxiliar != null) {
			if (auxiliar.ASCII == dato)
				auxiliar.codigoHuff = codigo;
			auxiliar = auxiliar.siguiente;
		}
	}//Fin setHuff

	/**
	 * Asigna el codigo huff al valor en la tabla al que se esta apuntando
	 * 
	 * @param huff
	 *            el codigo a asignar en la llave
	 */
	public void setHuff(String huff) {
		this.codigoHuff = huff;
	}//Fin setHuff

	/**
	 * Retorna el siguiente en la lista
	 * 
	 * @return el siguiente en la lista
	 */
	public TablaCodigos getSiguiente() {
		return this.siguiente;
	}

	/**
	 * Asigna al siguiente en la lista al que esta apuntando
	 * 
	 * @param siguiente
	 *            el siguiente
	 */
	public void setSiguiente(TablaCodigos siguiente) {
		this.siguiente = siguiente;
		cantidadDatos++;
	}

	/**
	 * Asigna el dato al campo al que se esta apuntando en la lista
	 * 
	 * @param dato
	 *            el ASCII a asignar
	 */
	public void setDato(int dato) {
		this.ASCII = dato;
	}

	/**
	 * Retorna el codigo de compresion del ASCII mandado por parametro
	 * 
	 * @param dato
	 *            el ASCII del que se quiere el codigo
	 * @return codigo de compresion del ASCII mandado por parametro
	 */
	public String getCodigo(int dato) {
		return sacaHuff(dato);
	}

	/**
	 * Retorna el tamaño del ASCII mandado por parametro
	 * 
	 * @param dato
	 *            el ASCII del que se quiere el tamaño del codigo
	 * @return el tamaño del ASCII mandado por parametro
	 */
	public int getTamano(int dato) {
		TablaCodigos auxiliar = inicio;
		for (int i = 0; i < cantidadDatos; i++) {
			if (auxiliar.ASCII == dato)
				return auxiliar.tamanoCodigo;
			auxiliar = auxiliar.siguiente;
		}
		return 0;
	}

	/**
	 * Retorna el tamaño del codigo del ASCII enviado por parametro
	 * 
	 * @param dato
	 *            el ASCII enviado por parametro
	 * @return el tamaño del codigo del ASCII enviado por parametro
	 */
	public int tamanoCodigo(int dato) {
		return (sacaHuff(dato)).length();
	}

	/**
	 * Retorna si o no si el ASCII enviado por parametro existe en la tabla,
	 * para obtenerlo hace una iteracion general de la tabla
	 * 
	 * @param dato
	 *            el ASCII del cual se quiere saber si esta en la tabla
	 * @return si o no si el ASCII enviado por parametro existe en la tabla
	 */
	public boolean existe(int dato) {
		TablaCodigos auxiliar = inicio;
		while (auxiliar != null) {
			if (auxiliar.ASCII == dato)
				return true;
			auxiliar = auxiliar.siguiente;
		}
		return false;
	}

	/**
	 * Inserta un TablaCodigos con los datos enviados por parametros en la tabla
	 * 
	 * @param dato
	 *            ASCII del dato
	 * @param huff
	 *            codigo de compresion asignado al ASCII
	 */
	public void inserteDato(int dato, String huff) {
		TablaCodigos insertado = new TablaCodigos(dato, huff);
		if (cantidadDatos == 0 || inicio == null) {
			inicio = insertado;
			cola = insertado;
			cantidadDatos++;
		} else {
			cola.siguiente = insertado;
			cola = cola.siguiente;
			cantidadDatos++;
		}
	}

	/**
	 * Inserta un TablaCodigos con los datos enviados por parametros en la tabla
	 * 
	 * @param dato
	 *            ASCII del dato
	 * @param huff
	 *            codigo de compresion asignado al ASCII
	 * @param tamano
	 *            el tamaño que tiene el codigo asignado a ese ASCII
	 */
	public void inserteDato(int dato, String huff, int tamano) {
		TablaCodigos insertado = new TablaCodigos(dato, huff, tamano);
		if (cantidadDatos == 0 || inicio == null) {
			inicio = insertado;
			cola = insertado;
			cantidadDatos++;
		} else {
			cola.siguiente = insertado;
			cola = cola.siguiente;
			cantidadDatos++;
		}
	}

	/**
	 * Retorna el codigo huffman del ASCII enviado por parametro
	 * 
	 * @param ASCII
	 *            el dato llave de la tabla
	 * @return el codigo huffman del ASCII enviado por parametro
	 */
	public String sacaHuff(int ASCII) {
		TablaCodigos auxiliar = inicio;
		for (int i = 0; i < cantidadDatos; i++) {
			if (auxiliar.ASCII != ASCII)
				auxiliar = auxiliar.siguiente;
			if (auxiliar.ASCII == ASCII)
				return auxiliar.codigoHuff;
		}
		return null;
	}

	/**
	 * Imprime la tabla completa (Metodo usado para la depuracion del codigo)
	 */
	public void imprimaTabla() {
		TablaCodigos auxiliar = inicio;
		for (int i = 0; i < cantidadDatos; i++) {
			System.out.println("ASCII = " + auxiliar.ASCII + " Codigo Huffman = " + auxiliar.codigoHuff);
			auxiliar = auxiliar.siguiente;
		}
	}

}
