package algorithms;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CustomList implements Collection<Object> {

    private static final int DEFAULT_INIT_LENGTH = 10;

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
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iter();
    }

    @Override
    public Object[] toArray() {
        Object[] newArr = new Object[size];
        System.arraycopy(elementData, 0, newArr, 0, size);
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

    /**
     *
     * arr1> 1, 2, 3, 4, 5
     * arr2> 3
     *
     *             X
     * arr1> 1, 2, 3, 4, 5
     *               <----
     *             |
     *             V
     * arr1> 1, 2, 4, 5, 5
     *             |
     *             V
     * arr1> 1, 2, 4, 5, null (flush size attribute)
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        int r = 0, w = 0;

        try {
            for (; r < size; r++)
                if (c.contains(elementData[r]))
                    elementData[w++] = elementData[r];
        } finally {
            // 防止 contains 拋出錯誤時
            // if contains throw exception save current update
            if (r != size) {
                System.arraycopy(elementData, r,
                        elementData, w,
                        size - r);
                w += size - r;
            }
            // 將最後元素指定為 null,並更新 size 大小
            // assign last element is null and update size is new length
            if (w != size) {
                // clear to let GC do its work
                for (int i = w; i < size; i++)
                    elementData[i] = null;
                size = w;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
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

    private class Iter implements Iterator<Object> {

        int cursor; // 下一個元素

        int lastEl; // 當前元素

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Object next() {
            int i = cursor;
            Object[] elementData = CustomList.this.elementData;
            cursor = i + 1;
            return elementData[lastEl = i];
        }
    }
}
