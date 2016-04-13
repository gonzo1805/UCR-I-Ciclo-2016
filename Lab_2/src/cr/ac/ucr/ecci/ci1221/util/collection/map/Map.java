package cr.ac.ucr.ecci.ci1221.util.collection.map;

/**
 * Represents a Map Model.
 *
 * @author Rodrigo A. Bartels
 */
public interface Map<K, V> {

    /**
     * @param key the key to insert.
     * @param value the value associated with the key.
     */
    void put(K key, V value);

    /**
     * Returns the value associated with the given key.
     *
     * @param key the key.
     *
     * @return the value.
     */
    V get(K key);

    /**
     * Removes all the elements of the map.
     */
    void clear();

    /**
     * Removes the value with the given key from the array.
     *
     * @param key the key of the value to remove.
     *
     * @return value.
     */
    V remove(K key);

    /**
     * Whether the map contains the given key.
     */
    boolean containsValue(V value);

    /**
     * Whether the map contains the given value or not.
     */
    boolean containsKey(K key);

    /**
     * Whether the map is empty or not.
     */
    boolean isEmpty();

    /**
     * Returns the number of key-value mappings in this map.  If the
     * map contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of key-value mappings in this map
     */
    int size();
}
