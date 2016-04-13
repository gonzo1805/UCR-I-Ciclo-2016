package cr.ac.ucr.ecci.ci1221.util.collection.stack;

import cr.ac.ucr.ecci.ci1221.util.collection.Collection;

/**
 * Represents a Stack Model.
 *
 * @param <E> the type of the elements that the stack holds.
 */
public interface Stack<E> extends Collection<E> {

    /**
     * Adds an element to the stack
     * @param element the element to be added.
     */
    void push(E element);

    /**
     * Returns the element at the top of the stack, without removing it from the stack.
     *
     * @return top element.
     */
    E peek();

    /**
     * Returns the element at the top of the stack, removing it from the stack.
     *
     * @return the element at the top of the stack.
     */
    E pop();
}
