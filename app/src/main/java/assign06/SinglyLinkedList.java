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
        if(this.size < 1){
            throw new NoSuchElementException("Linked list has no nodes");
        }
        return this.head.value;
    }

    @Override
    public E getLast() throws NoSuchElementException {
        if(this.size < 1){
            throw new NoSuchElementException("Linked list has no nodes");
        }
        return this.tail.value;
    }

    @Override
    public int indexOf(E element) {
        Node<E> curr = this.head;
        int i = 0;
        while(!curr.value.equals(element)){
            if(i >= this.size-1){
                return -1;
            }
            curr = curr.next;
            i++;
        }
        return i;
    }

    @Override
    public void insert(int index, E element) throws IndexOutOfBoundsException {
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if(index == 0){
            insertFirst(element);
            return;
        }
        else if(index == this.size){
            insertLast(element);
            return;
        }
        
        Node<E> curr = this.head;
        for (int i = 0; i < index - 1; i++){
            curr = curr.next;
        }

        Node<E> afterCurr = curr.next;
        Node<E> newNode = new Node<>(element, afterCurr);
        curr.next = newNode;

        this.size++;
    }

    @Override
    public void insertFirst(E element) {
        this.head = new Node<E>(element, head);
        if (this.size == 0) tail = head;
        size++;
    }

    @Override
    public void insertLast(E element) {
        if(this.size == 0){
            this.head = new Node<E>(element);
            this.tail = head;
            size++;
            return;    
        }

        Node<E> node = new Node<E>(element);
        this.tail.next = node;
        this.tail = node;
        size++;
    }

    @Override
    public E delete(int index) throws IndexOutOfBoundsException {
        if (size < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");
        if (index == this.size -1){
            E val = this.tail.value;
            this.tail = null;
            size--;
            return val;
        }

        Node<E> curr = head;
        for (int i = 0; i < index - 1; i++){
            curr = curr.next;
        }

        Node<E> target = curr.next;
        curr.next = target.next;
        target.next = null;
        size--;
        return target.value;
    }

    @Override
    public E deleteFirst() throws NoSuchElementException {
        if(size <= 0) throw new NoSuchElementException("Linked list is empty");

        E value = head.value;
        this.head = head.next;
        size--;

        return value;
    }

    @Override
    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator(head);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        Node<E> current = head;
        for (int i = 0; i < size; i++){
            array[i] = current.value;
            current = current.next;
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

        public Node(E value){
            this.value = value;
            this.next = null;
        }

        public Node(E value, Node<E> next){
            this.value = value;
            this.next = next;
        }
    }

    public class SinglyLinkedListIterator implements Iterator<E> {
        private Node<E> currentNode;
        private Node<E> previousNode;
        private boolean wasNextCalled;

        public SinglyLinkedListIterator(Node<E> head){
            this.currentNode = head;
        }

        @Override
        public boolean hasNext() {
            if (currentNode == null) return false;
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
            //TODO - Come back to this method
            if (!wasNextCalled) throw new IllegalStateException("Remove cannot be called before next");
            previousNode.next = currentNode.next;
            currentNode.next = null;
            currentNode = previousNode.next;

            wasNextCalled = false;
        }
    }
}
