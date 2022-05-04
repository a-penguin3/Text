import java.util.Arrays;

public class Sort {

    static int[] nums;

    /**
     * 冒泡排序
     * O(n * (1 + n) * n /2 )
     */
    public static void bubbleSort() {
        int boundary = nums.length - 1;
        while (boundary != 0) {
            for (int j = 0; j < boundary; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(j, j + 1);
                }
            }
            boundary--;
        }
    }

    /**
     * 选择排序
     */
    public static void selectionSort() {
        int boundary = 0;
        while (boundary != nums.length - 1) {
            int mix = boundary;
            for (int i = boundary + 1; i < nums.length; i++) {
                if (nums[i] < nums[mix]) {
                    mix = i;
                }
            }
            swap(boundary, mix);
            boundary++;
        }
    }

    /**
     * 快速排序
     */
    public static void insertionSort() {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    swap(i,j);
                    break;
                }
            }
        }
    }

    public static void mergeSort(){

    }

    public static void swap(int start, int end) {
        int cur = nums[start];
        nums[start] = nums[end];
        nums[end] = cur;
    }

    public static void main(String[] args) {
        nums = new int[]{3, 1, 6, 2, 4, 2, 7};
//        bubbleSort();
//        selectionSort();
        insertionSort();
        for (int num : nums) {
            System.out.print(num);
        }
    }
}
