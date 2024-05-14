package data_structure.stack;

import java.util.Arrays;
import java.util.Iterator;

public class CustomStack implements Stack<Object> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] stackCapacity;

    private int size;

    public CustomStack() {
        stackCapacity = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void push(Object o) {
        grow();
        stackCapacity[size++] = o;
    }

    private void grow() {
        if (size == stackCapacity.length) {
            int oldCapacity = stackCapacity.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            stackCapacity = Arrays.copyOf(stackCapacity, newCapacity);
        }
    }

    @Override
    public Object pop() {
        if (stackCapacity.length <= 0) throw new IndexOutOfBoundsException("index out of bound");
        int firstIndex = stackCapacity.length - size--;
        Object o = peek();
        stackCapacity[firstIndex] = null;
        System.arraycopy(stackCapacity, firstIndex,
                stackCapacity, firstIndex,
                (stackCapacity.length - firstIndex));
        return o;
    }

    @Override
    public Object peek() {
        return stackCapacity[size];
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iter();
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
            return CustomStack.this.size != cursor;
        }

        @Override
        public Object next() {
            Object[] stackCapacity = CustomStack.this.stackCapacity;
            int i = cursor;
            cursor = i + 1;
            return stackCapacity[lastEl = i];
        }
    }

}
