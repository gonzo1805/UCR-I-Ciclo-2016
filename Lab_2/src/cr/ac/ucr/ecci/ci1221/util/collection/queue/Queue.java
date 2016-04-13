package cr.ac.ucr.ecci.ci1221.util.collection.queue;

import cr.ac.ucr.ecci.ci1221.util.collection.Collection;

/**
 * Represents a Queue Model.
 *
 * @param <E> the type of the elements that the stack holds.
 */
public interface Queue<E> extends Collection<E> {

    /**
     * Adds an element to the end of the queue.
     *
     * @param element the element to be added.
     */
    void enqueue(E element);

    /**
     * Returns the first element of the queue, removing it from the queue.
     *
     * @return the element at the top of the stack.
     */
    E dequeue();

    /**
     * Returns the first element of the queue, without removing it from the queue.
     *
     * @return top element.
     */
    E top();

}
