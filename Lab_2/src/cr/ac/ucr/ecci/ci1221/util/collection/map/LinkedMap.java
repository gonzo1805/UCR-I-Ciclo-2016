package cr.ac.ucr.ecci.ci1221.util.collection.map;

/**
 * Implementation of a map using a linked list.
 *
 * @author Rodrigo A. Bartels
 */
public class LinkedMap<K, V> implements Map<K, V>{

	private static int cantidadDatos;
	private Node cabeza;
	
    @Override
    public void put(K key, V value) {
    	if (cantidadDatos == 0){
    		Node nodo = new Node(new Entry(key, value));
    		cabeza = nodo;
    		cantidadDatos++;
    	}
    	else {
    		Node nodo = new Node(new Entry(key, value));
    		nodo.setNext(cabeza);
    		cabeza = nodo;
    		cantidadDatos++;
    	}
    }

    @Override
    public V get(K key) {
        Node aux = cabeza;
    	for (int i=0; i<cantidadDatos; i++){
        	if ((aux.getEntry().getKey()).equals(key)){
        		return aux.getEntry().getValue();
        	}
        	aux = aux.getNext();
        }
    	System.out.println("La key no se ha encontrado");
    	return null;
    }

    @Override
    public void clear() {
    	cabeza.setNext(null);
    	cabeza = null;
    	cantidadDatos = 0;
    }

    @Override
    public V remove(K key) {
        Node aux = cabeza;
        Node anterior = cabeza;
    	for (int i=0; i<cantidadDatos; i++){
    		if (i==0 && (aux.getEntry().getKey()).equals(key)){
    			V retorno = cabeza.getEntry().getValue();
    			cabeza = cabeza.getNext();
    			cantidadDatos--;
    			return retorno;
    		}
        	if ((aux.getEntry().getKey()).equals(key)){
        		V retorno = aux.getEntry().getValue();
        		anterior.setNext(aux.getNext());
        		cantidadDatos--;
        		return retorno;
        	}
        	anterior = aux;
        	aux = aux.getNext();
        }
    	return null;
    }

    @Override
    public boolean containsValue(V value) {
       Node aux = cabeza; 
       for (int i=0; i<cantidadDatos; i++){
    	   if ((aux.getEntry().getValue()).equals(value)){
    		   return true;
    	   }
    	   aux = aux.getNext();
       }
       return false;
    }

    @Override
    public boolean isEmpty() {
        return cantidadDatos == 0;
    }

    @Override
    public boolean containsKey(K key) {
    	Node aux = cabeza; 
        for (int i=0; i<cantidadDatos; i++){
     	   if ((aux.getEntry().getKey()).equals(key)){
     		   return true;
     	   }
     	   aux = aux.getNext();
        }
        return false;
    }

    @Override
    public int size() {
        return cantidadDatos;
    }

    /**
     * Private class for the nodes of the linked list.
     */
    private class Node{
        Entry entry;
        Node next;
        
        public Node(){}
        
        public Node(Entry entry){
        	this.entry = entry;
        }
        
        public void setNext(Node nodo){
        	this.next = nodo;
        }
        
        public Node getNext(){
        	return this.next;
        }
        
        public Entry getEntry(){
        	return this.entry;
        }
        
        public void setEntry(Entry entry){
        	this.entry = entry;
        }
    }

    /**
     * Private class for the key-value pairs of the map.
     */
    private class Entry{
        K key;
        V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
        
        public V getValue(){
        	return this.value;
        }
        
        public K getKey(){
        	return this.key;
        }
    }
}
