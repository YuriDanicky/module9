package module9;

import java.util.Arrays;

public class MyArrayList<E> {

    private Object[] arrayElement;
    private final int DEFAULT_CAPACITY = 10;
    private int size = 0;

    public MyArrayList() {
        this.arrayElement = new Object[DEFAULT_CAPACITY];
    }

    /**
     * adds an element to the end
     */

    public void add(E e) {
        if (e != null) {
            if (arrayElement.length > size) {
                add(e, arrayElement);
            } else {
                arrayElement = growArray();
                add(e, arrayElement);
            }
        }
    }

    /**
     * private method for public add()
     */

    private void add(E e, Object[] arrayElement) {
        arrayElement[size] = e;
        size++;
    }

    /**
     * private method. Grows an array
     */

    private Object[] growArray() {
        return Arrays.copyOf(arrayElement, (int) (size * 1.5));
    }

    /**
     * Removes element at index
     */

    public void remove(int index) throws ArrayIndexOutOfBoundsException {
        if ((index >= 0) && (arrayElement[index] != null) && (index < size)) {
            Object[] newArray = new Object[arrayElement.length];
            System.arraycopy(arrayElement, 0, newArray, 0, index);
            System.arraycopy(arrayElement, index + 1, newArray, index, arrayElement.length - index - 1);
            arrayElement = newArray;
            size--;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * public method. Assigns a link to a new array with standard length
     */

    public void clear() {
        arrayElement = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * get size of collection
     */

    public int size() {
        return size;
    }

    /**
     * public method, returns the element at index
     */

    public E get(int index) throws IndexOutOfBoundsException {
        if (index < size) {
            return (E) arrayElement[index];
        } else throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (arrayElement[0] != null) {
            for (Object obj : arrayElement) {
                if (obj != null) {
                    stringBuilder.append(obj);
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
