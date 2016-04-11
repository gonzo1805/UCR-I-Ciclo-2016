/**
 * Estructura usada para la creacion del ArbolBinario a partir de las
 * frecuencias de los ASCII en el texto original y el ordenamiento de los datos
 * tomados del mismo.
 * 
 * @author Gonzalo
 *
 */
public class ListaOrdenada {

	/**
	 * Atributos de la clase Cabeza: el inicio de la lista siempre guardada para
	 * poder hacer las respectivas iteraciones CantidadNodos: la cantidad de
	 * nodos que contiene la lista
	 */
	private Nodo cabeza;
	private static int cantidadNodos = 0;

	/**
	 * Constructor de ListaOrdenada
	 */
	public ListaOrdenada() {
		cabeza = null;
	}

	/**
	 * Retorna la cabeza de la lista
	 * 
	 * @return la cabeza de la lista
	 */
	public Nodo getCabeza() {
		return this.cabeza;
	}

	/**
	 * Inserta el nodo enviado por parametro en la lista, de manera ordenada por
	 * medio de las frecuencias de los nodos. En caso de ser iguales, el nuevo
	 * nodo se insertara a la izquierdo de su igual
	 * 
	 * @param nuevoNodo
	 *            nodo a inserta en la lista
	 */
	public void insertarNodo(Nodo nuevoNodo) {
		if (cabeza == null) {
			cabeza = nuevoNodo;
			cantidadNodos++;
		} else {
			if (nuevoNodo.getValor().getFrecuencia() <= cabeza.getValor().getFrecuencia()) {
				nuevoNodo.setSiguiente(cabeza);
				cabeza = nuevoNodo;
				cantidadNodos++;
				return;
			} else {
				Nodo actual = cabeza;
				Nodo anterior = cabeza;
				while (actual != null) {
					if (actual.getSiguiente() == null
							&& actual.getValor().getFrecuencia() != nuevoNodo.getValor().getFrecuencia()) {
						actual.setSiguiente(nuevoNodo);
						cantidadNodos++;
						return;
					}
					if (actual.getSiguiente() == null
							&& actual.getValor().getFrecuencia() == nuevoNodo.getValor().getFrecuencia()) {
						nuevoNodo.setSiguiente(actual);
						anterior.setSiguiente(nuevoNodo);
						cantidadNodos++;
						return;
					}
					if (nuevoNodo.getValor().getFrecuencia() > actual.getValor().getFrecuencia()) {
						anterior = actual;
						actual = actual.getSiguiente();
					} else if (nuevoNodo.getValor().getFrecuencia() == actual.getValor().getFrecuencia()) {
						nuevoNodo.setSiguiente(actual);
						anterior.setSiguiente(nuevoNodo);
						cantidadNodos++;
						return;
					} else if (nuevoNodo.getValor().getFrecuencia() < actual.getValor().getFrecuencia()) {
						nuevoNodo.setSiguiente(actual);
						anterior.setSiguiente(nuevoNodo);
						cantidadNodos++;
						return;

					}

				}
			}

		}
	}// Fin insertarNodo

	/**
	 * Inserta un arbol dentro de la lista, simplementa crea un nodo con ese
	 * arbol y llama al insertador de nodos
	 * 
	 * @param arbol
	 */
	public void insertarArbol(ArbolBinario arbol) {
		insertarNodo(new Nodo(arbol));
	}// Fin insertarArbol

	/**
	 * Borra un nodo de la lista y la deja acomodada
	 * 
	 * @param nodo
	 *            nodo a borrar de la lista
	 */
	public void borrarNodo(Nodo nodo) {
		Nodo actual = cabeza;
		Nodo anterior = cabeza;

		for (int i = 0; i < cantidadNodos; i++) {

			if (nodo.getValor().getASCII() == cabeza.getValor().getASCII()) {
				cabeza = cabeza.getSiguiente();
				cantidadNodos--;
				return;
			}
			if (nodo.getValor().getASCII() == actual.getValor().getASCII()) {

				if (actual.getSiguiente() == null) {
					anterior.setSiguiente(null);
					cantidadNodos--;
					return;
				}
				if (actual.getSiguiente() != null) {
					anterior.setSiguiente(actual.getSiguiente());
					cantidadNodos--;
					return;
				}

			}

			if (nodo.getValor().getASCII() != actual.getValor().getASCII()) {
				anterior = actual;
				actual = actual.getSiguiente();
			}

		}

	}// Fin borrarNodo

	/**
	 * Genera el ArbolBinario contenedor de los ASCII y creado por orden de
	 * frecuencias para la creacion de los codigos de compresion para el texto
	 * original a partir de la ListaOrdenada
	 * 
	 * @param lista
	 *            la lista que contiene todos los ArbolBinarios que seran
	 *            acomodados en el arbol para los codigos
	 */
	public void generaArbol(ListaOrdenada lista) {

		while (cantidadNodos != 1) {

			Nodo nodo1 = new Nodo();
			nodo1.setValor(lista.cabeza.getValor());
			Nodo nodo2 = new Nodo();
			nodo2.setValor(lista.cabeza.getSiguiente().getValor());

			borrarNodo(nodo1);
			borrarNodo(nodo2);
			insertarArbol(new ArbolBinario(nodo1.getValor(), nodo2.getValor()));
			/**
			 * Metodo usado para la depuracion del codigo
			 */
			// imprimaLista();
		}
	}// fin generaArbol

	/**
	 * Imprime la lista de izquierda a derecha
	 */
	public void imprimaLista() {
		System.out.println("\n");
		Nodo nodo = cabeza;
		for (int i = 0; i < cantidadNodos; i++) {
			System.out.println(nodo.getValor().getFrecuencia() + " " + nodo.getValor().getASCII());
			nodo = nodo.getSiguiente();
		}
	}// fin imprimaLista
}// fin clase
