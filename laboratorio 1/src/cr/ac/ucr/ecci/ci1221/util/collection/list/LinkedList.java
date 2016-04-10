package cr.ac.ucr.ecci.ci1221.util.collection.list;

import cr.ac.ucr.ecci.ci1221.util.collection.Iterator;

/**
 * Implementation of a List model using a linked list data structure.
 *
 * @param <E> the type of the elements that the list holds.
 */
public class LinkedList<E> implements List<E> {

    private Nodo<E> cabeza;
    private Nodo<E> dato;
    private static int cantidadNodos = 0;

    /**
     * Adds the given element to the given position.
     *
     * @param element  the element.
     * @param position the position.
     */
    @Override
    public void add(E element, int position) {
        Nodo<E> nodo = cabeza;
        Nodo<E> anterior = cabeza;

        if (position == 1) {
            nodo = new Nodo<>();
            nodo.valor = element;
            nodo.next = cabeza;
            cabeza = nodo;
            cantidadNodos++;
        } else if (position > 1) {
            for (int i = 0; i < position; i++) {
                anterior = nodo;
                nodo = nodo.next;
            }
            nodo = new Nodo<>();
            nodo.valor = element;
            anterior.next = nodo;
            nodo.next = (anterior.next).next;
            cantidadNodos++;
        }
    }

    /**
     * removes the element at the given position.
     *
     * @param position the position.
     */
    @Override
    public void remove(int position) {
        if (position == 1) {
        	cabeza = cabeza.next;
            cantidadNodos--;
            return;
        }
        Nodo<E> nodo = cabeza;
        Nodo<E> anterior = cabeza;
        if (position > 1) {
            for (int i = 0; i < position; i++) {
                anterior = nodo;
                nodo = nodo.next;
            }
            anterior.next = nodo.next;
            cantidadNodos--;
        }
    }

    /**
     * Returns the initial position of the given element.
     *
     * @param element the element to find.
     * @return the position of the found element.
     */
    @Override
    public int find(E element) {
        Nodo<E> nodo = cabeza;
        for (int i = 0; i <= cantidadNodos; i++) {
            if (nodo.valor == element) {
                return i;
            }
            nodo = nodo.next;
        }
        System.out.println("El elemento no fue encontrado dentro de la lista, se retornara un 0");
        return 0;
    }

    /**
     * Returns the element at the given position.
     *
     * @param position the position.
     * @return the element at the given position.
     */
    @Override
    public E get(int position) {
        if (cabeza == null) {
            System.out.println("La lista esta vacia");
            return null;
        }
        Nodo<E> nodo = cabeza;
        for (int i = 0; i < position; i++) {
            nodo = nodo.next;
        }
        if (position > cantidadNodos) {
            System.out.println("Se solicito un espacio en la lista que esta no posee porque es mas grande que la misma, se retornara un null");
        }//Preguntar si es necesaria la advertencia o generar una validacion de entrada de datos
        return nodo.valor;

    }

    /**
     * Replaces the element in the given position with the given element.
     *
     * @param position the position
     * @param element  the element to replace.
     * @return the replaced element.
     */
    @Override
    public E set(int position, E element) {
        E retorno;
        if (position == 1) {
            retorno = cabeza.valor;
            cabeza.valor = element;
            return retorno;
        }
        Nodo<E> actual = cabeza;

        if (position > 1) {
            for (int i = 0; i < position; i++) {
                actual = actual.next;
            }

            retorno = actual.valor;
            actual.valor = element;
            return retorno;

        }
        return null;
    }

    /**
     * Adds an element to the collection.
     *
     * @param element the element to add to the collection.
     */
    @Override
    public void add(E element) {
        if (cabeza == null) {
        	cabeza.valor = element;
            cantidadNodos++;
            return;
        }
        Nodo<E> actual = cabeza;
        Nodo<E> anterior = cabeza;
        for (int i = 0; i < cantidadNodos; i++) {
            anterior = actual;
            actual = actual.next;
        }
        actual.valor = element;
        anterior.next = actual;
        cantidadNodos++;
    }

    /**
     * Removes an element to the collection.
     *
     * @param element the element to remove to the collection.
     */
    @Override
    public void remove(E element) {
        if (cabeza.valor == element) {
        	cabeza = cabeza.next;
            cantidadNodos--;
            return;
        }
        Nodo<E> anterior = cabeza;
        Nodo<E> nodo = cabeza;
        while (nodo.valor != element) {
            anterior = nodo;
            nodo = nodo.next;
        }
        anterior.next = nodo.next;
        cantidadNodos--;

    }

    /**
     * Checks if the collection contains the given Element.
     *
     * @param element the element to look for.
     * @return true if the element is in the collection, false otherwise.
     */
    @Override
    public boolean contains(E element) {
        Nodo<E> nodo = cabeza;
        for (int i = 0; i < cantidadNodos; i++) {
            if (nodo.valor == element) {
                return true;
            }
            nodo = nodo.next;
        }
        return false;
    }

    /**
     * Returns the size of the collection.
     *
     * @return the size of the collection.
     */
    @Override
    public int size() {
        return cantidadNodos;
    }

    /**
     * Whether the collection is empty or not.
     *
     * @return Whether the collection is empty or not
     */
    @Override
    public boolean isEmpty() {
        if (cantidadNodos != 0) {
            return false;
        }
        return true;
    }

    /**
     * Removes all the elements from the collection.
     */
    @Override
    public void clear() {
    	cabeza.next = null;
    	cabeza.valor = null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new B();
    }

    /**
     * Sorts a collection.
     */
    @Override
    public void sort() {

    }

    private class B<E> implements Iterator<E> {
    	int actual = 0;
    	
        @Override
        public boolean hasNext() {
        	return actual < cantidadNodos;
        }

        @Override
        public E next() {
        	if (actual == cantidadNodos) System.out.println("Ya esta en el final de la lista");
        	Nodo<E> auxiliar = (Nodo<E>) cabeza;
        	for (int i=0; i<actual; i++){
        		auxiliar = auxiliar.getNext();
        	}
        	actual++;
        	return auxiliar.valor;
        }
    }

    private class Nodo<E> {

        private Nodo next = null;
        private E valor;

        public void setValor(E valor) {
            this.valor = valor;
        }
        
        public E getValor(){
        	return this.valor;
        }
        
        public void setNext(Nodo siguiente){
        	this.next = siguiente;
        }
        
        public Nodo getNext(){
        	return this.next;
        }
    }
}
