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
     * 插入排序
     */
    public static void insertionSort() {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    swap(i, j);
                    break;
                }
            }
        }
    }

    public static void mergeSort() {

    }

    /**
     * 快速排序
     * 注意一个问题：为什么用while不用for
     * 因为while只会在条件满足后进行指针数值变换
     * 而for在进入判断时就会进行指针数值变换
     */
    public static void quickSort(int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start, j = end;
        int temp = nums[start];
        while (i != j) {
            while (nums[j] >= temp && j > i)
                j--;
            while (nums[i] <= temp && j > i)
                i++;
            if (j > i)
                swap(i, j);
        }
        swap(start, i);
        quickSort(start, i - 1);
        quickSort(i + 1, end);
    }

    /**
     * 希尔排序（插入排序 升级版）
     */
    public static void shellSort() {
        int gap = nums.length / 2;
        int sign = nums.length / gap;
        while (true) {
            for (int i = 0; i < nums.length; i++) {
                if (i + (gap * (sign - 1)) >= nums.length) {
                    break;
                }
                for (int j = 1; j < sign; j++) {
                    if (nums[i] > nums[i + (gap * j)]) {
                        swap(i, i + (gap * j));
                    }
                }
            }
            gap = gap / 2;
            if (gap == 0) break;
            sign = nums.length / gap;
        }
    }

    /**
     * 标准答案 希尔排序
     * @param arr
     */
    public static void sort(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            //相当于划定窗体 然后排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    //插入排序采用交换法
                    swap(j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    public static void swap(int start, int end) {
        int cur = nums[start];
        nums[start] = nums[end];
        nums[end] = cur;
    }

    public static void main(String[] args) throws Exception {
        nums = new int[]{3, 1, 6, 2, 4, 2, 7};
//        bubbleSort();  //冒泡
//        selectionSort(); // 选择
//        insertionSort(); // 插入
//        quickSort(0, nums.length - 1); //快速
//        shellSort();
        sort(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
