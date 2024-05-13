package data_structure.stack;

import java.util.Arrays;

public class CustomStack implements Stack<Object> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] stackCapacity;

    private int size;

    private int firstIndex;

    public CustomStack() {
        stackCapacity = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void push(Object o) {
        grow();
        stackCapacity[size++] = o;
        firstIndex = size;
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
        int firstIndex = stackCapacity.length - size-- ;
        Object o = peek();
        stackCapacity[firstIndex] = null;
        System.arraycopy(stackCapacity, firstIndex,
                stackCapacity, firstIndex,
                (stackCapacity.length-firstIndex));
        return o;
    }

    @Override
    public Object peek() {
        return stackCapacity[size];
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = 0; i < size; i++) {
            sb.append(stackCapacity[i]);
            sb.append(", ");
        }
        return sb.append("]").toString();
    }
}
