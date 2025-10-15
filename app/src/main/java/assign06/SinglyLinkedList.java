package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E> {
    private SingleLinkedNode<E> head;
    private SingleLinkedNode<E> tail;
    private int size;

    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        return this.head.value;
    }

    @Override
    public E getLast() throws NoSuchElementException {
        return this.tail.value;
    }

    @Override
    public int indexOf(E element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public void insert(int index, E element) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void insertFirst(E element) {
        SingleLinkedNode<E> node = new SingleLinkedNode<E>();
        node.value = element;
        node.linkedNode = head;
        this.head = node;
    }

    @Override
    public void insertLast(E element) {
        SingleLinkedNode<E> node = new SingleLinkedNode<E>();
        node.value = element;
        this.tail.linkedNode = node;
        this.tail = node;
    }

    @Override
    public E delete(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public E deleteFirst() throws NoSuchElementException {
        SingleLinkedNode<E> node = head;
        this.head = head.linkedNode;
        return node.value;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }
    

    public static class SingleLinkedNode<E> {
        private E value;
        private SingleLinkedNode<E> linkedNode;

        public SingleLinkedNode(){
            this.value = null;
            this.linkedNode = null;
        }
    }
}
