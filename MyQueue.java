package module9;

public class MyQueue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            tail = newNode;
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return head.element;
    }

    public T poll() {
        Node<T> result = head;
        if(head.next == null) {
            tail = null;
        } else {
            head.next.prev = null;
        }
        head = head.next;
        size--;
        return result.element;
    }

    @Override
    public String toString() {
        if (size < 1) {
            return "[ ]";
        } else {
            Node<T> temp = head;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (int i = 0; i < size; i++) {
                stringBuilder.append(temp.element);
                stringBuilder.append(", ");
                temp = temp.next;
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

}
