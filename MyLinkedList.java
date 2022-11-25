package module9;

public class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void remove(int index) {
        normalIndex(index);
        Node<T> temp;
        if (index <= (size / 2)) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
        }

        if (index == 0) {
            removeAtFirst();
        } else if (index == size) {
            removeAtLast();
        } else {
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            temp.prev = null;
            temp.next = null;
        }
        size--;
    }

    private void removeAtFirst() {
        if (head.next == null) {
            tail = null;
        } else {
            head.next.prev = null;
        }
        head = head.next;
    }

    private void removeAtLast() {
        if (head.next == null) {
            head = null;
        } else {
            tail.prev.next = null;
        }
        tail = tail.prev;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        normalIndex(index);
        Node<T> temp;
        if (index <= (size / 2)) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp.element;
    }

    private void normalIndex(int index) throws IndexOutOfBoundsException {
        if (!((index < size) && (index >= 0))) {
            throw new IndexOutOfBoundsException();
        }
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
