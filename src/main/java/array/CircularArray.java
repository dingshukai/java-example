package array;

/**
 * 圆形数组，把数组看成是一个圆环。
 *
 * @author: dingshukai
 * @date: 2021/8/19
 */
public class CircularArray {

    private int[] data;
    private static int INIT_CAPACITY = 8;
    private int size;
    private int capacity;
    private int head;
    private int tail;

    public CircularArray() {
        size = 0;
        capacity = INIT_CAPACITY;
        data = new int[capacity];
    }

    public int size() {
        return size;
    }

    //获得第n个元素
    public int get(int index) {
        return data[(index+head)%capacity];
    }

    // 在头部添加元素。
    // 不挪动数组的其他元素（下同），而是在第一个元素的左边添加。如果左边没有位置了，则折行添加到数组的最后一个位置。如果最后一个位置也满了，则扩容。
    public void addFirst(int elem) {
        int beforeHead = indexBeforeHead();
        if(beforeHead==tail) {
            grow();
            beforeHead = indexBeforeHead();
        }

        data[beforeHead] = elem;
        size++;
        head = beforeHead;
    }

    private int indexBeforeHead() {
        return (head -1 + capacity) % capacity;
    }

    // 删除第一个元素。
    //
    public int removeFirst() {
        if(size<=0)
            throw new ArrayIndexOutOfBoundsException("data is empty");
        int ret = data[head];
        head = (head+1)%capacity;
        size --;
        return ret;
    }

    public int getFirst() {return 0;}

    public void addLast(int elem) {}
    public int removeLast() {return 0;}
    public int getLast() {return 0;}
 }
