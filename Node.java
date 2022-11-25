package module9;

public class Node<T> {

    public T element;
    public Node<T> prev;
    public Node<T> next;

    public Node() {
    }

    public Node(T element) {
        this.element = element;
    }
}
