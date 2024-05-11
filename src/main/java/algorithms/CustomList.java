package algorithms;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CustomList implements Collection<Object> {

    private static final int DEFAULT_INIT_LENGTH = 10;

    private static final Object[] DEFAULT_EMPTY_ELEMENT_DATA = {};

    transient Object[] elementData = {};

    private static int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object elementDatum : elementData)
            if (elementDatum.equals(o))
                return true;
        return false;
    }

    @Override
    public Iterator<Object> iterator() {
        // TODO
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] newArr = new Object[size];
        System.arraycopy(elementData,0, newArr, 0, size);
        // TODO
        return newArr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Object o) {
        if (size == elementData.length) {
            grow(Math.max(size, DEFAULT_INIT_LENGTH));
        }
        elementData[size++] = o;
        return true;
    }

    private void grow(int minLength) {
        int oldLength = elementData.length;
        int newLength = oldLength + (oldLength >> 1);
        if (minLength > newLength)
            newLength = minLength;
        elementData = Arrays.copyOf(elementData, newLength);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    public boolean remove(int index) {
        // 判斷 index 是否超過長度
        if (size < index) throw new IndexOutOfBoundsException("index " + index + " out of bounds");
        int numMoved = size - index - 1; // 獲得陣列需覆蓋的 index
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null; // 將最後一個元素指向 null,讓GC回收
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<?> c) {
        Object[] targetArr = c.toArray();
        for (int i = 0; i < targetArr.length; i++)
            add(targetArr[i]);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) return false;
        Object[] targetArr = c.toArray();
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (Object elementDatum : elementData) {
            if (elementDatum == null) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(elementDatum);
            sb.append(",").append(" ");
        }
        return "[]";
    }
}
