package ss10_list.exercise.arraylist;

import java.util.Arrays;

public class MyArrayList<E> {
    private int size = 0;
    private static final int CAPACITY = 10;
    private Object[] element;

    public MyArrayList() {
        element = new Object[CAPACITY];
    }

    public MyArrayList(int capacity) {
        element = new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Object[] getElement() {
        return element;
    }

    public void setElement(Object[] element) {
        this.element = element;
    }

    private void ensureCapa() {
        int newSize = this.element.length * 2;
        element = Arrays.copyOf(element, newSize);
    }

    public boolean add(E e) {
        if (size == element.length) {
            ensureCapa();
        }
        element[size++] = e;
        return true;
    }

    public void addIndex(int index, E element) {
        if (size == this.element.length) {
            ensureCapa();
        }
        if (index < 0 || index > size) {
            System.out.println("Vị trí này không chèn đc");
        }
        for (int i = size; i > index; i--) {
            this.element[i] = this.element[i - 1];
        }
        this.element[index] = element;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            System.out.println("Vị trí này không xóa đc");
        }
        for (int i = index; i < size; i++) {
            element[i] = element[i + 1];
            element[element.length - 1] = null;
        }
        return (E) element;
    }

    public E clone() {
        Object[] element2 = new Object[CAPACITY];
        for (int i = 0; i < size; i++) {
            element2[i] = element[i];
        }
        return (E) element2;
    }

    public int size() {
//        int count = 0;
//        for (int i = 0; i < element.length; i++) {
//            if (element[i] == null) {
//                count++;
//            }
//
//        }
//        return size = (this.element.length) - count;
        return size;
    }

    public boolean contain(E e) {
        for (int i = 0; i < getSize(); i++) {
            if (e.equals(element[i])) {
                return true;
            }
        }
        return false;
    }

    public int indexof(E e) {
        for (int i = 0; i < getSize(); i++) {
            if (e.equals(element[i])) {
                return i;
            }
        }
        return -1;
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) element[i];
    }


    public void clear() {
        for (int i = 0; i < size; i++) {
            if (element[i] != null) {
                element[i] = null;
            }
        }
        showList();
    }

    public void showList() {
        for (int i = 0; i < element.length; i++) {
            System.out.println(element[i]);
        }
    }


}


