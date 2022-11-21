package module9.myhashmap;

public class Node<T, K> {
    T key;
    K value;
    Node<T, K> next;

    public Node() {
    }

    public Node(T key) {
        this.key = key;
    }

    public Node(T key, K value) {
        this.key = key;
        this.value = value;
    }
}
