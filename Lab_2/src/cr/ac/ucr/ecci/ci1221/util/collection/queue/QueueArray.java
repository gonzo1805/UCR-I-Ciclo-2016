package cr.ac.ucr.ecci.ci1221.util.collection.queue;

import cr.ac.ucr.ecci.ci1221.util.collection.Iterator;

/**
 * Implementation of a Queue using an array.
 *
 * @author Rodrigo A. Bartels
 */
public class QueueArray<E> implements Queue<E> {

	private E[] elements = (E[]) new Object[50];
	private static int cantidadDatos = 0;
	private static int ultimo = 0;
	
    @Override
    public void enqueue(E element) {
    	if (elements[0] == null){
    		elements[0] = element;
    		cantidadDatos++;
    		ultimo++;
    		return;
    	}
    	if (cantidadDatos + 1 >= elements.length){
    		E[] sustituto = (E[]) new Object[elements.length * 2];
    		for (int i=0; i<cantidadDatos; i++){
    			sustituto[i+1] = elements[i];
    		}
    		sustituto[0] = element;
    		elements = sustituto;
    		cantidadDatos++;
    		ultimo++;
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
			cantidadDatos++;
			ultimo++;
			elements[cantidadDatos] = aux2;
    	}
    }

    @Override
    public E dequeue() {
        E retorno = elements[ultimo-1];
        elements[ultimo-1] = null;
        ultimo--;
        cantidadDatos--;
    	return retorno;
    }

    @Override
    public E top() {
        return elements[ultimo-1];
    }

    @Override
    public void add(E element) {
    	enqueue(element);
    }

    @Override
    public E remove(E element) {
        if (element == elements[ultimo-1]){
        	return dequeue();
        }
        else {
        	for (int i=0; i<cantidadDatos; i++){
        		if (elements[i] != element){
        			;
        		}
        		if (elements[i] == element){
        			E retorno = elements[i];
        			while (i < cantidadDatos){
        				elements[i] = elements[i+1];
        			}
        			cantidadDatos--;
        			ultimo--;
        			return retorno;
        		}
        	}
        }
    	return null;
    }

    @Override
    public boolean contains(E element) {
        for (int i=0; i<cantidadDatos; i++){
        	if (elements[i] == element) return true;
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
    	elements = (E[]) new Object[50];
    	cantidadDatos = 0;
    	ultimo = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new It();
    }
    
    private class It<E> implements Iterator<E> {
    	
    	int actual = 0;
    	
    	public It() {}
    	
    	@Override
    	public boolean hasNext() {    		
    		return actual < cantidadDatos;
    	}
    	@Override
    	public E next() {
    		if (actual >= cantidadDatos){
    			System.out.println("No hay mas elementos");
    			return null;
    		}else {
    			E retorno = (E) elements[actual];
    			actual++;
    			return retorno;
    		}
    	}
    }
}
