package HW2.task1.list.iterator;

public interface MyIterator<T> {
    boolean hasNext();
    boolean hasPrevious();
    T next();
    T previous();
}
