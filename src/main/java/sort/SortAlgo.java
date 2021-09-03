package sort;

/**
 * 常见排序算法
 * 默认从小到大
 * @author: dingshukai
 * @date: 2021/9/3
 */
public class SortAlgo {

    // 冒泡排序。就像冒泡一样。
    // 相邻的元素比较，如果左边元素更大，则交换。
    public static void bubbleSort(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-1-i; j++)
                if(arr[j]>arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
        }
    }

    // 选择排序。选择最大的，放到后面。
    public static void selectSort(int[] arr) {

    }

    // 插入排序。将当前元素插入已经有序的数组。
    public  static void insertSort(int[] arr) {

    }
}
