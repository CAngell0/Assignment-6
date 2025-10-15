package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Interface to represent a ordered collection, in which there is
 * a first element, a second element, and so on.
 *
 * @author CS 2420 course staff
 * @version 2025-10-02
 */
public interface List<E> extends Iterable<E> {
  /**
   * Remove all of the elements from this list.
   *
   * @implSpec O(1) running-time behavior for a singly-linked list.
   */
  void clear();

  /**
   * Determine whether this list is empty.
   *
   * @implSpec O(1) running-time behavior for a singly-linked list.
   *
   * @return true if this list contains no elements; false, otherwise
   */
  boolean isEmpty();

  /**
   * Determine the number of elements in this list.
   *
   * @implSpec O(1) running-time behavior for a singly-linked list.
   *
   * @return the number of elements in this list
   */
  int size();

  /**
   * Get the element at a specific position in this list.
   *
   * @implSpec O(N) running-time behavior for a singly-linked list, in the average case.
   *
   * @param index - the specified position
   * @return the element at the position
   * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
   */
  E get(int index) throws IndexOutOfBoundsException;

  /**
   * Get the first element in this list.
   *
   * @implSpec O(1) running-time behavior for a singly-linked list.
   *
   * @return the first element in this list
   * @throws NoSuchElementException if this list is empty
   */
  E getFirst() throws NoSuchElementException;

  /**
   * Get the last element in this list.
   *
   * @implSpec O(1) running-time behavior for a singly-linked list with a tail reference.
   *
   * @return the last element in this list
   * @throws NoSuchElementException if this list is empty
   */
  E getLast() throws NoSuchElementException;

  /**
   * Determine the index of the first occurrence of the specified element in this list,
   * or -1 if this list does not contain the element.
   *
   * @implSpec O(N) running-time behavior for a singly-linked list, in the average case.
   *
   * @param element - the element to search for
   * @return the index of the first occurrence; -1 if the element is not found
   */
  int indexOf(E element);

  /**
   * Insert an element at a specific position in this list.
   *
   * @implSpec O(N) running-time behavior for a singly-linked list, in the average case.
   *
   * @param index - the specified position
   * @param element - the element to add
   * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index > size())
   */
  void insert(int index, E element) throws IndexOutOfBoundsException;

  /**
   * Insert an element at the beginning of this list.
   *
   * @implSpec O(1) running-time behavior for a singly-linked list.
   *
   * @param element - the element to add
   */
  void insertFirst(E element);

  /**
   * Insert an element at the end of this list.
   *
   * @implSpec O(1) running-time behavior for a singly-linked list with a tail reference.
   *
   * @param element - the element to add
   */
  void insertLast(E element);

  /**
   * Delete and returns the element at a specific position in this list.
   *
   * @implSpec O(N) running-time behavior for a singly-linked list, in the average case.
   *
   * @param index - the specified position
   * @return the element at the position
   * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
   */
  E delete(int index) throws IndexOutOfBoundsException;

  /**
   * Delete and returns the first element from this list.
   *
   * @implSpec O(1) running-time behavior for a singly-linked list.
   *
   * @return the first element
   * @throws NoSuchElementException if this list is empty
   */
  E deleteFirst() throws NoSuchElementException;

  /**
   * Create and returns an iterator for this list.
   *
   * @return an iterator over the elements in this list in proper order (from first
   * element to last element)
   */
  public Iterator<E> iterator();

  /**
   * Generate an array containing all of the elements in this list in proper sequence
   * (from first element to last element).
   *
   * @implSpec O(N) running-time behavior for a singly-linked list.
   *
   * @return an array containing all of the elements in this list, in order
   */
  Object[] toArray();
}
