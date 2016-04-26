package cr.ac.ucr.ecci.ci1221.util.collection.queue;

import cr.ac.ucr.ecci.ci1221.util.collection.Iterator;

/**
 * Implementation of a queue using a linked list.
 *
 * @author Rodrigo A. Bartels
 */
public class QueueLinkedList<E> implements Queue<E> {

	private static int cantidadDatos = 0;
	Nodo cabeza;

	@Override
	public void enqueue(E element) {
		if (cantidadDatos == 0) {
			cabeza = new Nodo(element);
			cantidadDatos++;
		} else {
			Nodo nodo = new Nodo(element);
			nodo.setSiguiente(cabeza);
			cabeza = nodo;
			cantidadDatos++;
		}
	}

	@Override
	public E dequeue() {
		Nodo aux = cabeza;
		Nodo aux_anterior = cabeza;
		for (int i = 0; i < cantidadDatos-1; i++) {
			aux_anterior = aux;
			aux = aux.siguiente;
		}
		E retorno = aux.getDato();
		aux_anterior.setSiguiente(null);
		cantidadDatos--;
		return retorno;
	}

	@Override
	public E top() {
		Nodo aux = cabeza;
		for (int i = 0; i < cantidadDatos-1; i++) {
			aux = aux.siguiente;
		}
		return aux.getDato();
	}

	@Override
	public void add(E element) {
		enqueue(element);
	}

	@Override
	public E remove(E element) {
		Nodo aux = cabeza;
		Nodo aux_anterior = cabeza;
		for (int i = 0; i < cantidadDatos; i++) {
			if (i == cantidadDatos - 1 && element == aux.getDato()) {
				E retorno = aux.getDato();
				aux_anterior.setSiguiente(null);
				cantidadDatos--;
				return retorno;
			}
			if (element == aux.getDato()) {
				E retorno = aux.getDato();
				aux_anterior.setSiguiente(aux.getSiguiente());
				cantidadDatos--;
				return retorno;
			}
			aux_anterior = aux;
			aux = aux.siguiente;
		}
		return null;
	}

	@Override
	public boolean contains(E element) {
		Nodo aux = cabeza;

		for (int i = 0; i < cantidadDatos; i++) {
			if (element == aux.getDato()) {
				return true;
			}
			aux = aux.siguiente;
		}
		return false;
	}

	@Override
	public int size() {
		return cantidadDatos;
	}

	@Override
	public boolean isEmpty() {
		return cantidadDatos == 0;
	}

	@Override
	public void clear() {
		cabeza = null; 
		cantidadDatos = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new It();
	}

	private class Nodo {

		E dato;
		Nodo siguiente;

		public Nodo() {
		}

		public Nodo(E element) {
			this.dato = element;
		}

		public void setDato(E element) {
			this.dato = element;
		}

		public E getDato() {
			return this.dato;
		}

		public void setSiguiente(Nodo siguiente) {
			this.siguiente = siguiente;
		}

		public Nodo getSiguiente() {
			return this.siguiente;
		}

	}

	private class It<E> implements Iterator<E> {

		int actual = 0;
		
		public It() {
		}

		@Override
		public boolean hasNext() {
			return actual < cantidadDatos;
		}

		@Override
		public E next() {
			if (actual == cantidadDatos){
				System.out.println("Ya esta en el final de la lista");
			}
			else if (actual == 0){
				actual++;
				return  (E) cabeza.getDato();
			}
			else {
				Nodo aux = cabeza;
				for (int i=0; i<actual; i++){
					aux = aux.getSiguiente();
				}
				actual++;
				return (E) aux.getDato();
			}
			return null;
		}
	}
}
