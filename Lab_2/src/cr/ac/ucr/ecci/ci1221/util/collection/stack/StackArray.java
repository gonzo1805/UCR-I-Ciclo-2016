package cr.ac.ucr.ecci.ci1221.util.collection.stack;

import cr.ac.ucr.ecci.ci1221.util.collection.Iterator;

/**
 * Implementation of a stack using arrays.
 *
 * @author Rodrigo A. Bartels
 */
public class StackArray<E> implements Stack<E> {

	private E[] elements = (E[]) new Object[1000];
	private static int cantidadDatos = 0;

	@Override
	public void push(E element) {
		if (cantidadDatos == 0){
			elements[0] = element;
			cantidadDatos++;
			return;
		}
		if (cantidadDatos+1 >= elements.length) {
			E[] sustituto = (E[]) new Object[elements.length * 2];
			
			for (int i = 0; i < cantidadDatos; i++) {
				sustituto[i + 1] = elements[i];
			}
			sustituto[0] = element;
			elements = sustituto;
			cantidadDatos++;
		} else {
			E aux = elements[0];
			E aux2 = elements[1];
			for (int i = 0; i < cantidadDatos; i++) {
				elements[i + 1] = aux;
				aux = aux2;
				aux2 = elements[i+2];
			}
			elements[0] = element;
			cantidadDatos++;
		}
	}

	@Override
	public E peek() {
		return elements[0];
	}

	@Override
	public E pop() {
		E retorno = elements[0];
		for (int i = 0; i < cantidadDatos; i++) {
			elements[i] = elements[i + 1];
		}
		cantidadDatos--;
		return retorno;
	}

	@Override
	public void add(E element) {
		push(element);
	}

	@Override
	public E remove(E element) {
		for (int i = 0; i < cantidadDatos; i++) {
			if (elements[0] == element) {
				return pop();
			} else {
				if (elements[i] == element) {
					E retorno = elements[i];
					while (i != cantidadDatos) {
						elements[i] = elements[i + 1];
						i++;
					}
					cantidadDatos--;
					return retorno;
				}
			}
		}
		System.out.println("El elemento no esta en la lista");
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
		return (cantidadDatos == 0);
	}

	@Override
	public void clear() {
		elements = (E[]) new Object[50];
		cantidadDatos = 0;
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
			if (actual >= cantidadDatos) {
				System.out.println("No hay mas elementos");
				return null;
			} else {
				E retorno = (E) elements[actual];
				actual++;
				return retorno;
			}

		}
	}
}
