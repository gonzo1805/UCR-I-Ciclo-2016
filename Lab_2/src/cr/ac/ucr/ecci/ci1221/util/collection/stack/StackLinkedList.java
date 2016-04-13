package cr.ac.ucr.ecci.ci1221.util.collection.stack;

import cr.ac.ucr.ecci.ci1221.util.collection.Iterator;

/**
 * Implementation of a Stack using a linked list.
 *
 * @author Rodrigo A. Bartels
 */
public class StackLinkedList<E> implements Stack<E> {
	
	private Nodo cabeza;
	private static int tamano = 0;
	
    @Override
    public void push(E element) {
    	Nodo nodo = new Nodo(element);
    	nodo.setSiguiente(cabeza);
    	cabeza = nodo;
    	tamano++;
    }

    @Override
    public E peek() {
        return cabeza.getDato();
    }

    @Override
    public E pop() {
        E retorno = cabeza.getDato();
    	cabeza = cabeza.getSiguiente();
    	tamano--;
    	return retorno;
    }

    @Override
    public void add(E element) {
    	push(element);
    }

    @Override
    public E remove(E element) {
        return pop();
    }

    @Override
    public boolean contains(E element) {
        Nodo aux = cabeza;
        while (aux.getSiguiente() != null){
        	if (aux.getDato() == element) return true;
        	else aux = aux.getSiguiente();
        }
    	return false;
    }

    @Override
    public int size() {
        return tamano;
    }

    @Override
    public boolean isEmpty() {
        return (tamano == 0);
    }

    @Override
    public void clear() {
    	cabeza.setSiguiente(null);
    	cabeza.setDato(null);
    }

    @Override
    public Iterator<E> iterator() {
        return new It();
    }
    
    private class It<E> implements Iterator<E>{
    	int actual = 0;
    	
    	public It(){
    		
    	}
    	
		@Override
		public boolean hasNext() {
			actual++;
			return	actual < tamano;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}
    	
    }
    
    private class Nodo {
    	E dato;
    	Nodo siguiente = null;
    	
    	public Nodo(){}
    	
    	public Nodo(E element){
    		this.dato = element;
    	}
    	
    	public void setDato(E dato){
    		this.dato = dato;
    	}
    	
    	public void setSiguiente(Nodo siguiente){
    		this.siguiente = siguiente;
    	}
    	
    	public E getDato(){
    		return this.dato;
    	}
    	
    	public Nodo getSiguiente(){
    		return this.siguiente;
    	}
    }
}
