package cr.ac.ucr.ecci.ci1221.util.collection.queue;

import cr.ac.ucr.ecci.ci1221.util.collection.Iterator;

/**
 * Implementation of a queue using a circular array.
 *
 * @author Rodrigo A. Bartels
 */
public class QueueCircularArray<E> implements Queue<E> {

	private E[] elements = (E[]) new Object[100];
	private static int write = 0;
	private static int read = 0;
	private static int cantidadDatos = 0;

	@Override
	public void enqueue(E element) {
		if (cantidadDatos + 1 > elements.length) {
			E[] auxiliar = (E[]) new Object[cantidadDatos * 2];
			for (int i = 0; i < cantidadDatos; i++) {
				auxiliar[i] = elements[i];
			}
			elements = auxiliar;
		}
		elements[write] = element;
		write++;
		cantidadDatos++;

	}

	@Override
	public E dequeue() {
		if (read == write) {
			System.out.println("La cola esta vacia, se retornara null");
			return null;
		} else {
			E aux = elements[read];
			elements[read] = null;
			cantidadDatos--;
			read++;
			return aux;
		}
	}

	@Override
	public E top() {
		return elements[write - 1];
	}

	@Override
	public void add(E element) {
		enqueue(element);
	}

	@Override
	public E remove(E element) {
		if (element == elements[read]) {
			return dequeue();
		} else if (element == elements[write]) {
			E aux = elements[write];
			elements[write] = null;
			write--;
			cantidadDatos--;
			return aux;
		} else {
			E aux1 = elements[0];
			E aux2 = elements[0];
			for (int i = 0; i < cantidadDatos; i++) {
				if (elements[i] == element) {
					while (i != elements.length) {
						elements[i] = elements[i + 1];
						i++;
					}
					write--;
					cantidadDatos--;
					return element;
				}
				if (elements[i] != element) {
					;
				}
			}
		}
		return null;
	}

	@Override
	public boolean contains(E element) {
		for (int i = 0; i < cantidadDatos; i++) {
			if (elements[i] == element) {
				return true;
			}
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
		E[] elements = (E[]) new Object[100];
		cantidadDatos = 0;
		write = 0;
		read = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new It();
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
			E aux = (E) elements[actual];
			actual++;
			return aux;
		}
	}
}
