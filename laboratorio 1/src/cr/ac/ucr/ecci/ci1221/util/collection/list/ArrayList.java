package cr.ac.ucr.ecci.ci1221.util.collection.list;

import cr.ac.ucr.ecci.ci1221.util.collection.Iterator;

/**
 * Implementation of a List model using arrays.
 *
 * @param <E> the type of the elements  that the list holds.
 */
public class ArrayList<E> implements List<E> {

  /**
   * Adds the given element to the given position.
   *
   * @param element  the element.
   * @param position the position.
   */
  @Override
  public void add(E element, int position) {
	  
  }

  /**
   * removes the element at the given position.
   *
   * @param position the position.
   */
  @Override
  public void remove(int position) {

  }

  /**
   * Returns the initial position of the given element.
   *
   * @param element the element to find.
   * @return the position of the found element.
   */
  @Override
  public int find(E element) {
    return 0;
  }

  /**
   * Returns the element at the given position.
   *
   * @param position the position.
   * @return the element at the given position.
   */
  @Override
  public E get(int position) {
    return null;
  }

  /**
   * Replaces the element in the given position with the given element.
   *
   * @param position the position
   * @param element  the element to replace.
   * @return the replaced element.
   */
  @Override
  public E set(int position, E element) {
    return null;
  }

  /**
   * Adds an element to the collection.
   *
   * @param element the element to add to the collection.
   */
  @Override
  public void add(E element) {

  }

  /**
   * Removes an element to the collection.
   *
   * @param element the element to remove to the collection.
   */
  @Override
  public void remove(E element) {

  }

  /**
   * Checks if the collection contains the given Element.
   *
   * @param element the element to look for.
   * @return true if the element is in the collection, false otherwise.
   */
  @Override
  public boolean contains(E element) {
    return false;
  }

  /**
   * Returns the size of the collection.
   *
   * @return the size of the collection.
   */
  @Override
  public int size() {
    return 0;
  }

  /**
   * Whether the collection is empty or not.
   *
   * @return Whether the collection is empty or not
   */
  @Override
  public boolean isEmpty() {
    return false;
  }

  /**
   * Removes all the elements from the collection.
   */
  @Override
  public void clear() {

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
  
  private class A<E> implements Iterator<E>{
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
