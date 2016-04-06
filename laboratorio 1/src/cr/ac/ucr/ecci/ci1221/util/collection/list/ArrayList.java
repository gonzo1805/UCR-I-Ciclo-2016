package cr.ac.ucr.ecci.ci1221.util.collection.list;

import cr.ac.ucr.ecci.ci1221.util.collection.Iterator;

/**
 * Implementation of a List model using arrays.
 *
 * @param <E>
 *            the type of the elements that the list holds.
 */
public class ArrayList<E> implements List<E> {

	private static int cantidadDatos = 0;
	private E[] lista = (E[]) new Object[1];
	private static int tamañoLista = 1;

	/**
	 * Adds the given element to the given position.
	 *
	 * @param element
	 *            the element.
	 * @param position
	 *            the position.
	 */
	@Override
	public void add(E element, int position) {
		if (position - 1 <= cantidadDatos) {
			E[] lista2 = (E[]) new Object[cantidadDatos + 1];
			for (int i = 0; i < cantidadDatos; i++) {
				if (i < position) {
					lista2[i] = lista[i];
				} else if (i == position) {
					lista2[i] = element;
				} else if (i > position) {
					lista2[i + 1] = lista[i];
				}
			}
			lista = lista2;
			cantidadDatos++;
		} else if (position - 1 <= cantidadDatos) {
			System.out.println("Se intento ingresar un dato fuera de los limites del Array");
		}
	}

	/**
	 * removes the element at the given position.
	 *
	 * @param position
	 *            the position.
	 */
	@Override
	public void remove(int position) {
		boolean marcador = false;
		int x = 0;
		E[] listaAuxiliar = (E[]) new Object[cantidadDatos];
		for (int i=0; i<cantidadDatos-1; i++){
			if (i == position-1) marcador = true;
			if (marcador == false) x++; listaAuxiliar[i] = lista[x];
			if (marcador == true){
				listaAuxiliar[x] = lista[i+1];
				x++;
			}
		}cantidadDatos--;
		/*E[] lista2 = (E[]) new Object[cantidadDatos - 1];
		if (position-1 <= cantidadDatos) {
			for (int i = 0; i < cantidadDatos; i++) {
				if (i < position-1) {
					lista2[i] = lista[i];
				} else if (i == position-1) {

				} else if (i > position-1) {
					lista2[i] = lista[i + 1];
				}
			}
		}*/
	}

	/**
	 * Returns the initial position of the given element.
	 *
	 * @param element
	 *            the element to find.
	 * @return the position of the found element.
	 */
	@Override
	public int find(E element) {
		for (int i = 0; i < cantidadDatos; i++) {
			if (lista[i] == element) {
				return i;
			}
		}
		System.out.println("No se encontro en la lista el elemento dado, se devolvera un numero magico contrario al dato solicitado");
		return 1*10^20;
	}

	/**
	 * Returns the element at the given position.
	 *
	 * @param position
	 *            the position.
	 * @return the element at the given position.
	 */
	@Override
	public E get(int position) {
		return lista[position];
	}

	/**
	 * Replaces the element in the given position with the given element.
	 *
	 * @param position
	 *            the position
	 * @param element
	 *            the element to replace.
	 * @return the replaced element.
	 */
	@Override
	public E set(int position, E element) {
		if (position > cantidadDatos) {
			System.out.println("Se intenta sobreescribir en una posicion que la lista no posee, se retornara null");
			return null;
		}
		E auxiliar = lista[position];
		lista[position] = element;
		return auxiliar;
	}

	/**
	 * Adds an element to the collection.
	 *
	 * @param element
	 *            the element to add to the collection.
	 */
	@Override
	public void add(E element) {

		if (tamañoLista < cantidadDatos+1){
			E[] listaAuxiliar = (E[]) new Object[cantidadDatos*2];
			for (int i=0; i<cantidadDatos; i++){
				listaAuxiliar[i] = lista[i];
			}
			lista = listaAuxiliar;
			tamañoLista = cantidadDatos*2;
		}
		if (cantidadDatos == 0){
			lista[0] = element;
		}
		lista[cantidadDatos] = element;
		/*E[] lista2 = (E[]) new Object[cantidadDatos + 1];
		if (cantidadDatos == 0) {
			lista2[0] = element;
		} else {
			for (int i = 0; i <= cantidadDatos; i++) {
				if (i == cantidadDatos) {
					lista2[i++] = element;
					break;
				}
				lista2[i] = lista[i];
				
			}

		}*/
		//lista = lista2;
		cantidadDatos++;
	}

	/**
	 * Removes an element to the collection.
	 *
	 * @param element
	 *            the element to remove to the collection.
	 */
	@Override
	public void remove(E element) {
		int i = 0;
		boolean puntoEncuentro = false;
		for (int x=0; x<cantidadDatos; x++){
			if (lista[x] != element) i++;
			else if (lista[x] == element){
				puntoEncuentro = true; 
			}
			if (puntoEncuentro == true){
				lista[x] = lista[i+1];
			}
			cantidadDatos--;
		}
		/*E[] lista2 = (E[]) new Object[cantidadDatos];
		if (find(element) == (1*10^20)){
			System.out.println("El numero que se intento eliminar no se encuentra en la lista");
			return;			
		}
		int z = find(element);
		
		for (int i = 0; i < cantidadDatos; i++) {
			if (i < z) {
				lista2[i] = lista[i];
			} else if (i == z) {

			} else if (i > z) {
				lista2[i] = lista[i + 1];
			}
		}*/

	}

	/**
	 * Checks if the collection contains the given Element.
	 *
	 * @param element
	 *            the element to look for.
	 * @return true if the element is in the collection, false otherwise.
	 */
	@Override
	public boolean contains(E element) {
		if (find(element) != (1*10^20)) {
			return true;
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
		return cantidadDatos;
	}

	/**
	 * Whether the collection is empty or not.
	 *
	 * @return Whether the collection is empty or not
	 */
	@Override
	public boolean isEmpty() {
		return (cantidadDatos == 0);
	}

	/**
	 * Removes all the elements from the collection.
	 */
	@Override
	public void clear() {
		lista = (E[]) new Object[1];
		cantidadDatos = 0;
		tamañoLista = 1;
	}

	/**
	 * Returns an iterator over elements of type {@code T}.
	 *
	 * @return an Iterator.
	 */
	@Override
	public Iterator<E> iterator() {
		return new A();
	}

	/**
	 * Sorts a collection.
	 */
	@Override
	public void sort() {

	}

	private class A<E> implements Iterator<E> {
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
