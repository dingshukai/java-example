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
        if(size==capacity)
            grow();

        if(size==0)
            head = tail = 0;
        else
            head = (head-1+capacity)%capacity;
        data[head] = elem;
        size++;
    }

    private void grow() {
        int[] newArray = new int[data.length*2];
        if(head<=tail) {
            for(int i=head; i<=tail; i++)
                newArray[i] = data[i];
        }else {
            for(int i=0; i<=tail; i++)
                newArray[i] = data[i];
            int more = newArray.length - data.length;
            for(int i=head; i<=data.length; i++)
                newArray[more+i] = data[i];
            head = more + head;
        }
        data = newArray;
        capacity = data.length;
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

    public int getFirst() {
        if(size==0)
            throw new IndexOutOfBoundsException();
        return data[head];
    }

    public void addLast(int elem) {
        if(size==capacity)
            grow();
        if(size==0)
            head = tail = 0;
        else
            tail = (tail + 1)%capacity;

        size++;
        data[tail] = elem;
    }
    public int removeLast() {
        if(size<=0)
            throw new ArrayIndexOutOfBoundsException("data is empty");
        int ret = data[tail];
        tail = (tail -1 +capacity)%capacity;
        size --;
        return ret;
    }
    public int getLast() {
        if(size<=0)
            throw new ArrayIndexOutOfBoundsException("data is empty");
        return data[tail];
    }
 }
