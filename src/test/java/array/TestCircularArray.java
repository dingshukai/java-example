package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author: dingshukai
 * @date: 2021/9/3
 */
public class TestCircularArray {

    @Test
    void normalTest() {
        CircularArray arr = new CircularArray();
        arr.addFirst(1);
        arr.addLast(2);
        arr.addLast(3);
        Assertions.assertEquals(3, arr.get(2));
    }
}
