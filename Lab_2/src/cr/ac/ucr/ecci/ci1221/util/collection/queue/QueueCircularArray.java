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
    	if (elements[0] == null){
    		elements[0] = element;
    		cantidadDatos++;
    		write++;
    	}
    	if (cantidadDatos + 1 >= elements.length){
    		E[] sustituto = (E[]) new Object[elements.length * 2];
    		for (int i=0; i<cantidadDatos; i++){
    			sustituto[i+1] = elements[i];
    		}
    		sustituto[0] = element;
    		elements = sustituto;
    		cantidadDatos++;
    		write++;
    	}
    	else {
    		E aux = elements[0];
			E aux2 = elements[1];
			for (int i = 0; i < cantidadDatos; i++) {
				elements[i + 1] = aux;
				aux = aux2;
				aux2 = elements[i+2];
			}
			elements[0] = element;
			elements[cantidadDatos] = aux2;
			cantidadDatos++;
			write++;
    	}
    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E top() {
        return null;
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
    
    private class It<E> implements Iterator<E> {
    	
    	int actual = 0;
    	
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
