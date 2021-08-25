package linkedlist;

/**
 * 双端队列。
 * 两头都可以进出。
 * 应该使用链表来实现，但不要借助于任何系统提供的链表。如果不会，先用数组代替。
 * 参数越界要抛异常。
 * 然后要写测试代码。
 * @author: dingshukai
 * @date: 2021/8/17
 */
public class IntQueue {
    private Node head;
    private Node tail;
    private int size ;

    public IntQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    // 获得头部元素
    public int getFirst( ) {
        if(head==null)
            throw new IndexOutOfBoundsException();
        return head.data;
    }
    // 在头部添加元素
    public void addFirst(int elem) {
        Node n = new Node();
        n.next = head;
        head = n;
        n.data = elem;
        size++;
        if(size==1)
            tail = n;
    }

    // 删除并返回头部元素
    public int removeFirst() {
        if(head==null)
            throw new IndexOutOfBoundsException();
        Node rem = head;
        head = rem.next;
        if(head==null)
            tail = null;
        size--;
        return rem.data;
    }

    // 获得尾部元素
    public int getLast( ) {
        if(tail==null)
            throw new IndexOutOfBoundsException();
        return tail.data;
    }

    // 在尾部添加元素
    public void addLast(int elem) {
        Node n = new Node();
        n.data = elem;
        n.prev = tail;
        tail = n;
        if(head==null)
            head = tail;
        size ++;
    }

    // 删除并返回尾部元素
    public int removeLast() {
        if(tail==null)
            throw new IndexOutOfBoundsException();
        Node last = tail;
        tail = tail.prev;
        if(tail==null)
            head = null;
        size--;
        return last.data;
    }

    // 队列大小
    int size() {return size;}

    // 序列化
    @Override
    public String toString() {return null;}

    private class Node {
        int data;
        Node prev;
        Node next;
    }
}
