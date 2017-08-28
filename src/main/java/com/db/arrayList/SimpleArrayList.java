package com.db.arrayList;

public class SimpleArrayList<T> implements List<T> {
    private final int SIZE = 16;
    private final int COEF = 4;

    private Object[] array = new Object[SIZE];
    private int lastElementIndex = 0;

    private void changeSize(int newSize) {
        Object[] newArray = new Object[newSize];
        System.arraycopy(array, 0, new Object[newSize], 0, lastElementIndex);
        array = newArray;
    }

    private Object[] shiftFromIndex(Object[] array, int index) {
        for (int i = index; i < lastElementIndex; i++) {
            array[i] = array[i + 1];
        }
        return array;
    }

    @Override
    public int size() {
        return lastElementIndex;
    }

    @Override
    public boolean isEmpty() {
        return lastElementIndex == 0;
    }

    @Override
    public void add(T item) {
        if (lastElementIndex == array.length - 1) {
            changeSize(array.length * 2);
        }
        lastElementIndex++;
        array[lastElementIndex] = item;
    }

    @Override
    public int indexOf(T item) {
        for (int i = 0; i < array.length; i++)
            if (item.equals(array[i])) {
                return i;
            }
        return -1;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public boolean contains(T item) {
        return indexOf(item) >= 0;
    }

    @Override
    public void remove(int index) {
        array = shiftFromIndex(array, index);
        lastElementIndex--;

        if (array.length > SIZE && lastElementIndex < array.length / COEF) {
            changeSize(array.length / 2);
        }
    }

    @Override
    public void clear() {
        for (Object o : array) {
            o = null;
        }
        lastElementIndex = 0;
    }
}
