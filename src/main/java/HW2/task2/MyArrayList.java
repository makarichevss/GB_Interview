package HW2.task2;

public class MyArrayList<T> {

    private Object[] list;
    private static final int DEFAULT_SIZE = 10;
    private int currentSize = 0;

    public MyArrayList(int size) {
        if (size > 0) {
            list = new Object[size];
        } else if (size == 0) {
            list = new Object[DEFAULT_SIZE];
        } else
            throw new RuntimeException("Size should be > 0");
    }

    public Object get(int index) {
        if (index > list.length) {
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    public int size() {
        return currentSize;
    }

    public void add(T item) {
        if (list.length > currentSize) {
            list[currentSize] = item;
            currentSize++;
        } else {
            Object[] temp = new Object[currentSize * 2];
            System.arraycopy(list, 0, temp, 0, list.length);
            list = temp;
            add(item);
        }
    }

    public void remove(int index) {
    }

    public void remove(T item) {
    }

    public void clear() {
        list = new Object[DEFAULT_SIZE];
        currentSize = 0;
    }
}
