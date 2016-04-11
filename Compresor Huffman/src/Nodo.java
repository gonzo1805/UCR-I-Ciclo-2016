/**
 * Clase que es el contener de ArbolBinario y el siguiente nodo, es usada para
 * la ListaOrdenada
 * 
 * @author Gonzalo
 *
 */
public class Nodo {
	//
	/**
	 * Atributos de la clase Valor: el ArbolBinario para todo lo relacionado con
	 * la compresion Siguiente: el siguiente nodo al ser una lista enlzada
	 */
	private ArbolBinario valor;
	private Nodo siguiente = null;

	/**
	 * Asigna el arbol mandado por parametro al arbol del nodo apuntado
	 * 
	 * @param valor
	 *            el arbol a asignarse
	 */
	public void setValor(ArbolBinario valor) {
		this.valor = valor;
	}

	/**
	 * Asigna el siguiente nodo a un nodo
	 * 
	 * @param siguiente
	 *            el nodo que es siguiente al apuntado
	 */
	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	/**
	 * Constructor de Nodo
	 */
	public Nodo() {

	}

	/**
	 * Constructor por parametro de Nodo
	 * 
	 * @param valor
	 *            el ArbolBinario que se contiene en el nodo
	 */
	public Nodo(ArbolBinario valor) {
		this.valor = valor;
	}

	/**
	 * Retorna el ArbolBinario del nodo
	 * 
	 * @return el ArbolBinario del nodo
	 */
	public ArbolBinario getValor() {
		return this.valor;
	}

	/**
	 * Retorna el siguiente nodo en la lista
	 * 
	 * @return el siguiente nodo en la lista
	 */
	public Nodo getSiguiente() {
		return this.siguiente;
	}

}
