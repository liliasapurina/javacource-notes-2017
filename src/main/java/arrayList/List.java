package arrayList;

public interface List<T> {
    int size();

    boolean isEmpty();

    void add(T item);

    int indexOf(T item);

    T get(int index);

    boolean contains(T item);

    void remove(int index);

    void clear();
}
