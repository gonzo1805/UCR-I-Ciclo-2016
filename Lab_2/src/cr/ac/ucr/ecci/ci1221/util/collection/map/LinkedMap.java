package cr.ac.ucr.ecci.ci1221.util.collection.map;

/**
 * Implementation of a map using a linked list.
 *
 * @author Rodrigo A. Bartels
 */
public class LinkedMap<K, V> implements Map<K, V>{

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * Private class for the nodes of the linked list.
     */
    private class Node{
        Entry entry;
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
    }
}
