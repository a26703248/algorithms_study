package data_structure.queue;

import java.util.Arrays;
import java.util.Iterator;

public class CustomQueue implements Queue<Object>{

    private final static int DEFAULT_CAPACITY = 10;

    private Object[] elementData;

    private int size;

    public CustomQueue() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void enqueue(Object o) {
        if (o == null) throw new NullPointerException("insert element is null");
        grow();
        elementData[size++] = o;
    }

    @Override
    public Object dequeue() {
        if (size == 0) throw new IndexOutOfBoundsException("index out of bound");
        Object o = elementData[0];
        System.arraycopy(elementData, 1, elementData, 0, size);
        elementData[size--] = null;
        return o;
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iter();
    }

    private void grow(){
        if (size >= elementData.length) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity>>1);
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        Iterator<Object> iter = iterator();
        while (iter.hasNext()) {
            sb.append(iter.next());
            if (!iter.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(", ");
        }
        return "[]";
    }

    private class Iter implements Iterator<Object> {

        private int cursor;

        private int lastEl;


        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Object next() {
            Object[] element = elementData;
            int i = cursor;
            cursor = i + 1;
            return element[lastEl = i];
        }
    }

}
