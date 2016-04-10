//
public class ListaOrdenada {

	private Nodo raiz;
	private static int cantidadNodos = 0;

	// ArbolBinario Arbol = new ArbolBinario();

	public ListaOrdenada() {
		raiz = null;
	}

	public Nodo getRaiz() {
		return this.raiz;
	}

	public void insertarNodo(Nodo nuevoNodo) {
		if (raiz == null) {
			raiz = nuevoNodo;
			cantidadNodos++;
		} else {
			if (nuevoNodo.getValor().getFrecuencia() <= raiz.getValor().getFrecuencia()) {
				nuevoNodo.setSiguiente(raiz);
				raiz = nuevoNodo;
				cantidadNodos++;
				return;
			} else {
				Nodo actual = raiz;
				Nodo anterior = raiz;
				while (actual != null) {
					if (actual.getSiguiente() == null) {
						actual.setSiguiente(nuevoNodo);
						cantidadNodos++;
						return;
					}
					if (nuevoNodo.getValor().getFrecuencia() < actual.getValor().getFrecuencia()) {
						nuevoNodo.setSiguiente(actual);	
						anterior.setSiguiente(nuevoNodo);										
						cantidadNodos++;
						return;
					}
					else if (nuevoNodo.getValor().getFrecuencia() == actual.getValor().getFrecuencia()){
						nuevoNodo.setSiguiente(actual);
						anterior.setSiguiente(nuevoNodo);
						cantidadNodos++;
						return;
					}
					else if (nuevoNodo.getValor().getFrecuencia() >= actual.getValor().getFrecuencia()) {
						anterior = actual;
						actual = actual.getSiguiente();					
																	
					}
					
				}
			}

		}
	}// Fin insertarNodo

	public void insertarArbol(ArbolBinario arbol) {
		insertarNodo(new Nodo(arbol));
	}// Fin insertarArbol
	

	/*public void combinarFrecuencias(Nodo arbol_1, Nodo arbol_2) {
		Nodo nuevoNodo = new Nodo();
		ArbolBinario nuevoArbol = new ArbolBinario();

		nuevoArbol.setFrecuencia(arbol_1.getValor().getFrecuencia() + arbol_2.getValor().getFrecuencia());
		nuevoNodo.setValor(nuevoArbol);

		if (arbol_1.getValor().getFrecuencia() < arbol_2.getValor().getFrecuencia()) {
			nuevoArbol.setHijoIzquierdo(arbol_1.getValor());
			nuevoArbol.setHijoDerecho(arbol_2.getValor());
		}
		if (arbol_1.getValor().getFrecuencia() >= arbol_2.getValor().getFrecuencia()) {
			nuevoArbol.setHijoIzquierdo(arbol_2.getValor());
			nuevoArbol.setHijoDerecho(arbol_1.getValor());
		}

		borrarNodo(arbol_1);
		borrarNodo(arbol_2);
		insertarNodo(nuevoNodo);
	}*/// Fin combinarFrecuencias, siempre mandar el arbol_2 como el de mas alta
		// frecuencia para poder tener un dato correcto en la raiz

	public void borrarNodo(Nodo nodo) {
		Nodo actual = raiz;
		Nodo anterior = raiz;

		for (int i = 0; i < cantidadNodos; i++) {

			if (nodo.getValor().getASCII() == raiz.getValor().getASCII()) {
				raiz = raiz.getSiguiente();
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
		/**
		 * if (nodo == raiz) { raiz = raiz.getSiguiente(); return; } if
		 * (actual.getSiguiente() == null) { anterior.setSiguiente(null);
		 * return; } if (actual.getSiguiente() != null) {
		 * anterior.setSiguiente(actual.getSiguiente()); }
		 */

	}// Fin borrarNodo

	public void generaArbol(ListaOrdenada lista) {

		while (cantidadNodos != 1) {
			
			Nodo nodo1 = new Nodo();
			nodo1.setValor(lista.raiz.getValor());
			Nodo nodo2 = new Nodo();
			nodo2.setValor(lista.raiz.getSiguiente().getValor());
			
			borrarNodo(nodo1);
			borrarNodo(nodo2);
			insertarArbol(new ArbolBinario(nodo1.getValor(), nodo2.getValor()));
			imprimaLista();
			
			//if (siguiente.getSiguiente() != null) {
				
				//actual = siguiente.getSiguiente();
				//siguiente = siguiente.getSiguiente().getSiguiente();
				

				// combinarFrecuencias(raiz, raiz.getSiguiente());
			//}
		}
	}

	public void imprimaLista() {
		System.out.println("\n");
		Nodo nodo = raiz;
		for (int i = 0; i < cantidadNodos; i++) {
			System.out.println(nodo.getValor().getFrecuencia() + " " + nodo.getValor().getASCII());
			nodo = nodo.getSiguiente();
		}
	}
}
