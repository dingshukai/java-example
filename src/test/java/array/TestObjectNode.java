package array;

import interview.ObjectNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author: dingshukai
 * @date: 2021/8/27
 */
public class TestObjectNode {

    @Test
    public void test() {

        testStr("{\"a\":\"b\"}");
        testStr("{}");
        //testStr("{}");
    }

    private void testStr(String str) {
        Assertions.assertEquals(str, ObjectNode.fromString(str).toString() );
    }
}
