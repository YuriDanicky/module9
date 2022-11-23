package module9.myhashmap;

public class MyHashMap<K, V> {

    private Node<K, V>[] table;
    private int capacity = 0;
    private int size;
    private final int START_CAPACITY = 16;
    private int tableFullness = 0;
    private int coefficientIncrease = 2;

    /**
     * constructor without parameters
     */
    public MyHashMap() {
        this.capacity = START_CAPACITY;
        table = (Node<K, V>[]) new Node[capacity];
    }

    /**
     * constructor with capacity of buckets
     *
     * @param capacity
     */
    public MyHashMap(int capacity) {
        this.capacity = capacity;
        table = (Node<K, V>[]) new Node[capacity];
    }

    /**
     * hash code for key
     *
     * @param key
     * @return
     */

    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * index definition for bucket
     *
     * @param h
     * @param capacity
     * @return
     */

    private int indexFor(int h, int capacity) {
        return h & (capacity - 1);
    }

    /**
     * put Node to the bucket. If bucket not empty, then the Linked List will be made in this bucket
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {

        if (tableFullness >= (capacity)) {
            table = increaseTable(table);
        }
        int bucketIndex = indexFor(hash(key), capacity);                                    //definition of bucket index

        Node<K, V> temp = table[bucketIndex];
        Node<K, V> newNode = new Node<>(key, value);

        if (table[bucketIndex] == null) {                                                   // if bucket empty
            table[bucketIndex] = newNode;
            tableFullness++;
            size++;
        } else {                                                                            // if bucket not empty
            while (temp.next != null) {
                if (newNode.key.equals(temp.key)) {
                    temp.value = newNode.value;
                    return;
                } else {
                    temp = temp.next;                                                        // go down node
                }
            }
            if (newNode.key.equals(temp.key)) {                                             //node.next == null && key == key
                temp.value = newNode.value;
                return;
            }
            temp.next = newNode;                                                            // write at the end
            size++;
        }
    }

    /**
     * get Value by Key
     *
     * @param key
     * @return
     */
    public V get(K key) {
        int bucketIndex = indexFor(hash(key), capacity);
        Node<K, V> temp = table[bucketIndex];
        if (key.equals(temp.key)) {
            return temp.value;
        }
        while (table[bucketIndex].next != null) {
            if (key.equals(temp.key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return temp.value;
    }

    /**
     * remove Node by Key
     *
     * @param key
     * @return
     */
    public boolean remove(K key) {
        int bucketIndex = indexFor(hash(key), capacity);
        Node<K, V> temp = table[bucketIndex];
        if (key.equals(temp.key)) {
            if (temp.next == null) {
                table[bucketIndex] = null;
                size--;
                return true;
            }
        }
        while (temp.next != null) {
            if (key.equals(temp.next.key)) {
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    /**
     * clear all elements on collection
     */
    public void clear() {
        table = (new MyHashMap<K, V>()).table;
    }

    /**
     * Increase array table[]
     */
    private Node<K, V>[] increaseTable(Node<K, V>[] table) {
        tableFullness = 0;
        capacity = table.length * coefficientIncrease;
        MyHashMap<K, V> tempHashMap = new MyHashMap<>(capacity);
        for (Node<K, V> data : table) {
            if (data != null) {
                while (data.next != null) {
                    tempHashMap.put(data.key, data.value);
                    data = data.next;
                }
                tempHashMap.put(data.key, data.value);
            }
        }
        tableFullness = tempHashMap.tableFullness;
        return tempHashMap.table;
    }
}
