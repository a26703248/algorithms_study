package data_structure.heap;

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

    public void remove(Object o) {
        int index = search(o);
        if (index == -1) return;
        removeInternal(index);
    }

    private void removeInternal(int index) {
        elementData[index] = elementData[--size];
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        while (left < size && (compare(elementData[index], elementData[left]) > 0
                || compare(elementData[index], elementData[right]) > 0)) {
            if (compare(elementData[left], elementData[right]) < 0) {
                swap(index, left);
                index = left;
            } else {
                swap(index, right);
                index = right;
            }
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
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
        for (int i = size - 1; i > 0; ) {
            // get parent index
            int parentIndex = (i - 1) / 2;
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

    public int search(Object o) {
        int cursor = 0;
        int node = 1;
        while (cursor < size) {
            cursor = node - 1; // 算出該節點階層起始索引值
            int nodeLevelEnd = cursor + node; // 該節點階層結束索引值
            int count = 0; // 發現數
            while (cursor < nodeLevelEnd) {
                if (compare(o, elementData[cursor]) == 0) return cursor; // 如果找到回傳 index
                if (cursor == 0 && compare(o, elementData[cursor]) < 0)  return -1;
                if (compare(o, elementData[cursor]) < 0 && compare(o, getParent(cursor)) > 0)
                        count++;
                cursor++;
            }
            if (count == node) {
                return -1;
            } else {
                node = node * 2; // 每個節點階層
            }
        }
        return -1;
    }

    private Object getParent(int index) {
        return (index - 1) * 2;
    }

    private int compare(Object o1, Object o2) {
        return o1.hashCode() - o2.hashCode();
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
