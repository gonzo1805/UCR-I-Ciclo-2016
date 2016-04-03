
public class ListaOrdenada {

    private Nodo raiz;
    private static int cantidadNodos = 0;

    ArbolBinario Arbol = new ArbolBinario();

    public ListaOrdenada() {
        raiz = null;
    }
    
    public Nodo getRaiz(){
    	return this.raiz;
    }

    public void insertarNodo(Nodo nuevoNodo) {
        if (raiz == null) {
            raiz = nuevoNodo;
            cantidadNodos++;
        } else {
            if (nuevoNodo.getValor().getFrecuencia() < raiz.getValor().getFrecuencia()) {
                nuevoNodo.setSiguiente(raiz);
                raiz = nuevoNodo;
                cantidadNodos++;
            } else {
                Nodo actual = raiz;
                Nodo anterior = raiz;
                while  (nuevoNodo.getValor().getFrecuencia() > actual.getValor().getFrecuencia()) {
                	if (actual.getSiguiente() == null){
                		actual.setSiguiente(nuevoNodo);
                		cantidadNodos++;
                		return;
                	}
                	if (nuevoNodo.getValor().getFrecuencia() <= actual.getValor().getFrecuencia()){
                		anterior.setSiguiente(nuevoNodo);
                		nuevoNodo.setSiguiente(actual.getSiguiente());
                		cantidadNodos++;
                		return;
                	}
                	if (nuevoNodo.getValor().getFrecuencia() > actual.getValor().getFrecuencia() && actual.getSiguiente() != null) {
                        actual = actual.getSiguiente();
                        anterior.setSiguiente(actual);
                	}    
                	
                	
                	
                	}                	        	                    
                }
                           
        }
    }// Fin insertarNodo

    public void insertarArbol(ArbolBinario arbol) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setValor(arbol);
        insertarNodo(nuevoNodo);
    }// Fin insertarArbol

    public void combinarFrecuencias(Nodo arbol_1, Nodo arbol_2) {
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
    }// Fin combinarFrecuencias, siempre mandar el arbol_2 como el de mas alta
    // frecuencia para poder tener un dato correcto en la raiz

    public void borrarNodo(Nodo nodo) {
        Nodo actual = raiz;
        Nodo anterior = raiz;

        while (nodo != actual) {
            anterior = actual;
            actual = actual.getSiguiente();
        
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
            }
        }
        /**
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
        }
        */
        cantidadNodos--;

    }// Fin borrarNodo

    public void generaArbol(Nodo raiz) {
        for (int i = 0; i < cantidadNodos; i++) {
            combinarFrecuencias(raiz, raiz.getSiguiente());
        }
    }
}
