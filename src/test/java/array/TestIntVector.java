package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author: dingshukai
 * @date: 2021/8/14
 */
public class TestIntVector {

    @Test
    public void testNormal() {
        IntVector vec = new IntVector();
        Assertions.assertEquals(0, vec.size());
        vec.append(12);
        Assertions.assertEquals(1, vec.size());
        vec.insertAt(0, 10);
        Assertions.assertEquals(2, vec.size());
        Assertions.assertEquals(10, vec.get(0));
        vec.insertAt(2, 15);
        Assertions.assertEquals(12, vec.get(1));
        vec.deleteAt(0);
        Assertions.assertEquals(12, vec.get(0));
        Assertions.assertEquals(15, vec.getLast());
    }

    @Test
    public void testToString() {
        IntVector vec = new IntVector();
        Assertions.assertEquals("[]", vec.toString());
        vec.append(12);
        Assertions.assertEquals("[12]", vec.toString());
        vec.append(45);
        Assertions.assertEquals("[12,45]", vec.toString());
    }

    @Test
    public void testExceptions() {
        IntVector vec = new IntVector();
        Assertions.assertThrows(IllegalArgumentException.class, ()->vec.get(0));
        Assertions.assertThrows(IllegalArgumentException.class, ()->vec.getLast());
        Assertions.assertThrows(IllegalArgumentException.class, ()->vec.deleteAt(0));
        Assertions.assertThrows(IllegalArgumentException.class, ()->vec.deleteAt(1));
        Assertions.assertThrows(IllegalArgumentException.class, ()->vec.insertAt(1,200));
        vec.append(100);
        Assertions.assertThrows(IllegalArgumentException.class, ()->vec.deleteAt(1));
        Assertions.assertThrows(IllegalArgumentException.class, ()->vec.insertAt(2,200));
    }

    @Test
    public void testGrow() {
        IntVector vec = new IntVector();
        int count = 0;
        for(int i=0; i<vec.capacity(); i++)
            vec.append(count++);
        Assertions.assertEquals(count, vec.capacity());
        int rand = (int) (Math.random()*10);
        vec.append(rand);
        Assertions.assertEquals(count*2, vec.capacity());
        Assertions.assertEquals(rand, vec.getLast());
    }
}
