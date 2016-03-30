
public class ListaOrdenada {

	private Nodo raiz;
	private static int cantidadNodos = 0;

	ArbolBinario Arbol = new ArbolBinario();
	
	public ListaOrdenada() {
		raiz = null;
	}

	private void insertarNodo(Nodo nuevoNodo) {
		if (raiz == null) {
			raiz = nuevoNodo;
		} else {
			if (nuevoNodo.getValor().getFrecuencia() < raiz.getValor().getFrecuencia()) {
				nuevoNodo.setSiguiente(raiz);
				raiz = nuevoNodo;
			} else {
				Nodo actual = raiz;
				Nodo anterior = raiz;
				while (nuevoNodo.getValor().getFrecuencia() > actual.getValor().getFrecuencia()) {
					anterior = actual;
					actual.setSiguiente(actual.getSiguiente());
				}
				if (nuevoNodo.getValor().getFrecuencia() < actual.getValor().getFrecuencia()) {
					nuevoNodo.setSiguiente(actual);
					anterior.setSiguiente(nuevoNodo);
				}
				if (nuevoNodo.getValor().getFrecuencia() >= actual.getValor().getFrecuencia()) {
					actual.setSiguiente(nuevoNodo);
				}
			}
		}
	}// Fin insertarNodo

	private void insertarArbol(ArbolBinario arbol) {
		Nodo nuevoNodo = new Nodo();
		nuevoNodo.setValor(arbol);

		if (raiz == null) {
			raiz = nuevoNodo;
			nuevoNodo.setSiguiente(null);
		} else {
			if (nuevoNodo.getValor().getFrecuencia() < raiz.getValor().getFrecuencia()) {
				nuevoNodo.setSiguiente(raiz);
				raiz = nuevoNodo;
			} else {
				Nodo actual = raiz;
				Nodo anterior = raiz;
				while (nuevoNodo.getValor().getFrecuencia() > actual.getValor().getFrecuencia()) {
					anterior = actual;
					actual = actual.getSiguiente();
				}
				if (nuevoNodo.getValor().getFrecuencia() < actual.getValor().getFrecuencia()) {
					nuevoNodo.setSiguiente(actual);
					anterior.setSiguiente(nuevoNodo);
				}
				if (nuevoNodo.getValor().getFrecuencia() >= actual.getValor().getFrecuencia()) {
					actual.setSiguiente(nuevoNodo);
				}
			}

		}cantidadNodos++;

	}// Fin insertarArbol

	private void combinarFrecuencias(Nodo arbol_1, Nodo arbol_2) {
		Nodo nuevoNodo = new Nodo();
		nuevoNodo.setValor(Arbol.combinaFrecuencias(arbol_1, arbol_2));	
		borrarNodo(arbol_1);
		borrarNodo(arbol_2);
		insertarNodo(nuevoNodo);
	}// Fin combinarFrecuencias, siempre mandar el arbol_2 como el de mas alta
		// frecuencia para poder tener un dato correcto en la raiz

	private void borrarNodo(Nodo nodo) {
		Nodo actual = raiz;
		Nodo anterior = raiz;

		while (nodo != actual) {
			anterior = actual;
			actual = actual.getSiguiente();
		}
		if (nodo == raiz) {
			raiz = raiz.getSiguiente();
			return;
		}
		if (actual.getSiguiente() == null) {
			anterior.setSiguiente(null);
			return;
		}
		if (actual.getSiguiente() != null) {
			anterior.setSiguiente(actual.getSiguiente());
		}cantidadNodos--;

	}// Fin borrarNodo

	public void generaArbol(Nodo raiz) {
		 for (int i=0; i<cantidadNodos; i++){
			 combinarFrecuencias(raiz,raiz.getSiguiente());
		 }
	}
}
