package data_structure;

import java.util.Arrays;

public class CustomHeap {

    private static final int DEFAULT_CAPACITY_LENGTH = 10;

    transient Object[] elementData = {};

    int size;

    public void add(Object o) {
        if (o == null) return;
        if (elementData.length <= size) grow();
        elementData[size++] = o;
        minHeapify();
    }

    /**
     * the heap is left priority
     * <pre>
     *          6
     *        /  \
     *       7    9
     * add 3
     *
     *  step1
     *          6
     * compare/  \
     *   --->7    9
     *   |  /
     *   |-3
     *
     * step2:
     *   compare
     *     ---->6
     *     |  /  \
     *     |-3    9
     *      /
     *     7
     *
     * result:
     *          3
     *        /  \
     *       6    9
     *      /
     *     7
     * </pre>
     */
    private void minHeapify() {
        for (int i = size-1; i>0;) {
            // get parent index
            int parentIndex = (i-1)/2;
            // is compare max or min
            if ((elementData[i].hashCode() - elementData[parentIndex].hashCode()) < 0) {
                // swap left element and current element
                swap(i, parentIndex);
            }
            // assign parent index id compare
            i = parentIndex;
        }
    }

    private void swap(int i, int leftLeafIndex) {
        Object o1 = elementData[i];
        elementData[i] = elementData[leftLeafIndex];
        elementData[leftLeafIndex] = o1;
    }

    private void grow() {
        int oldLength = Math.max(elementData.length, DEFAULT_CAPACITY_LENGTH);
        int newLength = oldLength + (oldLength >> 1);
        elementData = Arrays.copyOf(elementData, newLength);
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
