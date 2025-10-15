package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
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
        if(index >= this.size || index < 0){
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node<E> curr = this.head;
        int i = 0;
        while(i < index){
            curr = curr.next;
            i++;
        }
        return curr.value;
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
        Node<E> curr = this.head;
        int i = 0;
        while(!curr.value.equals(element)){
            curr = curr.next;
            i++;
        }
        return i;
    }

    @Override
    public void insert(int index, E element) throws IndexOutOfBoundsException {
        if(index == 0){
            insertFirst(element);
        }
        else if(index == this.size){
            insertLast(element);
        }
        
        Node<E> curr = this.head;
        int i = 0;
        while(i < index-1){
            curr = curr.next;
            i++;
        }
        Node<E> afterCurr = curr.next;
        Node<E> newNode = new Node<>();
        newNode.value = element;
        curr.next = newNode;
        newNode.next = afterCurr;
        this.size++;
    }

    @Override
    public void insertFirst(E element) {
        Node<E> node = new Node<E>();
        node.value = element;
        node.next = head;
        this.head = node;
    }

    @Override
    public void insertLast(E element) {
        Node<E> node = new Node<E>();
        node.value = element;
        this.tail.next = node;
        this.tail = node;
    }

    @Override
    public E delete(int index) throws IndexOutOfBoundsException {
        if (size == 0 || index == size) throw new IndexOutOfBoundsException("Index out of bounds");

        int i = 0;
        Node<E> curr = head;
        while (i < index-1){
            curr = curr.next;
            index++;
        }

        Node<E> target = curr.next;
        curr.next = target.next;
        target.next = null;
        return target.value;
    }

    @Override
    public E deleteFirst() throws NoSuchElementException {
        Node<E> node = head;
        this.head = head.next;
        return node.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimplyLinkedListIterator<E>();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        int i = 0;
        Node<E> current = head;
        while (i < size){
            array[i] = (Object) current.value;
            current = current.next;
            i++;
        }

        return array;
    }
    

    public static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(){
            this.value = null;
            this.next = null;
        }
    }

    public static class SimplyLinkedListIterator<E> implements Iterator<E> {
        private Node<E> currentNode;
        private Node<E> previousNode;
        private boolean wasNextCalled;

        @Override
        public boolean hasNext() {
            return currentNode.next != null;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException("There is not next element");
            previousNode = currentNode;
            currentNode = currentNode.next;
            wasNextCalled = true;
            return currentNode.value;
        }

        @Override
        public void remove() {
            if (!wasNextCalled) throw new IllegalStateException("Remove cannot be called before next");
            previousNode.next = currentNode.next;
            currentNode.next = null;
            currentNode = previousNode.next;
        }
    }
}
