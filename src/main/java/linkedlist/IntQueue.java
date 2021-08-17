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

    // 获得头部元素
    public int getFirst( ) {return 0;}
    // 在头部添加元素
    public void addFirst(int elem) {}

    // 删除并返回头部元素
    public int removeFirst() {return 0;}

    // 获得尾部元素
    public int getLast( ) {return 0;}

    // 在尾部添加元素
    public void addLast(int elem) {}

    // 删除并返回尾部元素
    public int removeLast() {return 0;}

    // 队列大小
    int size() {return 0;}

    // 序列化
    @Override
    public String toString() {return null;}
}
