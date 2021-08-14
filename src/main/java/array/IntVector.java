package array;

/**
 * 自动扩容的整数数组。
 *
 */
public class IntVector {

    // 存储元素的容器数组
    private int[] container;
    // 有效元素的个数
    private int size = 0;
    // 容器的初试大小
    private static int DEFAULT_CAPACITY = 8;
    /**
     * 构造方法
     */
    public IntVector() {
        container = new int[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }
    public int capacity() {
        return container.length;
    }

    public void append(int value) {
        grow();
        container[size++] = value;
    }

    public int get(int index) {
        if(!(index>=0 && index<size))
            throw new IllegalArgumentException("index must be in range [0, size) ");
        return container[index];
    }

    public int getLast() {
        return get(size-1);
    }

    public void insertAt(int index, int value) {
        if(!(index>=0 && index<=size))
            throw new IllegalArgumentException("index must be in range [0, size] ");
        grow();
        for(int i=size-1; i>=index; i--)
            container[i+1] = container[i];
        container[index] = value;
        size++;
    }

    public void deleteAt(int index) {
        if(!(index>=0 && index<size))
            throw new IllegalArgumentException("index must be in range [0, size) ");
        for(int i=index+1; i<size; i++)
            container[i-1] = container[i];
        size--;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0; i<size; i++) {
            sb.append(container[i]);
            if(i<size-1)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    private void grow() {
        if(size<container.length)
            return;
        int[] newContainer = new int[container.length*2];
        for(int i=0; i<size; i++)
            newContainer[i] = container[i];
        container = newContainer;
    }
}
