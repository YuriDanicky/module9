package module9.myhashmap;

public class MyHashMap<T, K> {

    private Node<T, K> head;
    private int size = 0;

    public void put(T key, K value) {
        if (isAlreadyHaveKey(key, value)) {
            remove(key);
        }
        Node<T, K> newNode = new Node<>(key, value);
        if (size != 0) {
            newNode.next = head;
        }
        head = newNode;
        size++;

    }

    private boolean isAlreadyHaveKey(T key, K value) {
        boolean result = false;
        Node<T, K> existsNode = new Node<>(key, value);
        Node<T, K> temp = head;
        for (int i = 0; i < size; i++) {
            if (existsNode.key.equals(temp.key)) {
                result = true;
                break;
            }
            temp = temp.next;
        }
        return result;
    }

    public void remove(T key) {
        Node<T, K> temp = head;
        Node<T, K> searchingNode = new Node<>(key);
        if (searchingNode.key.equals(temp.key)) {
            head = head.next;
            temp.next = null;
            size--;
        } else {
            for (int i = 0; i < size - 1; i++) {
                if (searchingNode.key.equals(temp.next.key)) {
                    temp.next = temp.next.next;
                    size--;
                    return;
                }
                temp = temp.next;
            }
        }
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public K get(T key) {
        Node<T, K> temp = head;
        Node<T, K> searchingNode = new Node<>(key);
        for (int i = 0; i < size; i++) {
            if (searchingNode.key.equals(temp.key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    @Override
    public String toString() {
        if (size < 1) {
            return "[ ]";
        } else {
            Node<T, K> temp = head;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (int i = 0; i < size; i++) {
                stringBuilder.append(temp.key);
                stringBuilder.append(" - ");
                stringBuilder.append(temp.value);
                stringBuilder.append(", ");
                temp = temp.next;
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }
}
