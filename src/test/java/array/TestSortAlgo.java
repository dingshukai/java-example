package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sort.SortAlgo;

/**
 * @author: dingshukai
 * @date: 2021/9/3
 */
public class TestSortAlgo {



    @Test
    public void testBubbleSort() {
        int a1[] = {};
        SortAlgo.bubbleSort(a1);
        Assertions.assertArrayEquals(new int[0], a1);
        int[] a2 = {12};
        SortAlgo.bubbleSort(a2);
        Assertions.assertArrayEquals(new int[]{12}, a2);
        int[] a3 = {12, 56};
        SortAlgo.bubbleSort(a3);
        Assertions.assertArrayEquals(new int[]{12,56}, a3);
        int[] a4 = {56, 12};
        SortAlgo.bubbleSort(a4);
        Assertions.assertArrayEquals(new int[]{12,56}, a4);
        int[] a5 = {56, 12, -45};
        SortAlgo.bubbleSort(a5);
        Assertions.assertArrayEquals(new int[]{-45, 12,56}, a5);
    }
}
