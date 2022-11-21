package module9.linkedlist;

public class Node<T> {

    T element;
    Node<T> prev;
    Node<T> next;

    public Node() {
    }

    public Node(T element) {
        this.element = element;
    }
}
