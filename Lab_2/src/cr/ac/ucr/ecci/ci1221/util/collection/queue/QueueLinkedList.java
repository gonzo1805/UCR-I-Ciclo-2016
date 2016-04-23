package cr.ac.ucr.ecci.ci1221.util.collection.queue;

import cr.ac.ucr.ecci.ci1221.util.collection.Iterator;

/**
 * Implementation of a queue using a linked list.
 *
 * @author Rodrigo A. Bartels
 */
public class QueueLinkedList<E> implements Queue<E>{

	private static int cantidadDatos = 0;
	Nodo cabeza;
	
    @Override
    public void enqueue(E element) {
    	if (cantidadDatos == 0){
    		cabeza = new Nodo(element);
    		cantidadDatos++;
    	}
    	else {
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
        for (int i=0; i<cantidadDatos; i++){
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
    	for (int i=0; i<cantidadDatos; i++){
        	aux = aux.siguiente;
        }
    	return aux.getDato();
    }

    @Override
    public void add(E element) {

    }

    @Override
    public E remove(E element) {
        return null;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
    
    private class Nodo {
    	
    	E dato;
    	Nodo siguiente;
    	
    	public Nodo(){}
    	
    	public Nodo(E element){
    		this.dato = element;
    	}
    	
    	public void setDato(E element){
    		this.dato = element;
    	}
    	
    	public E getDato(){
    		return this.dato;
    	}
    	
    	public void setSiguiente(Nodo siguiente){
    		this.siguiente = siguiente;
    	}
    	
    	public Nodo getSiguiente(){
    		return this.siguiente;
    	}
    	
    }
    
    private class It<E> implements Iterator<E>{
    	
    	public It() {}
    	
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
