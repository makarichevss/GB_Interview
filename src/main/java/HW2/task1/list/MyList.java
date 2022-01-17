package HW2.task1.list;

import HW2.task1.list.iterator.MyIterable;

public interface MyList<T> extends MyIterable {
    int size();
    T get(int index);
    void add(T val);
    void remove(T val);
}
