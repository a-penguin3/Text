package arrs;

import java.util.Arrays;

/**
 * 偶前奇后
 */
public class Demo905 {
    public static int[] sortArrayByParity(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        while (head != tail) {
            if (nums[head] % 2 == 0) head++;
            else {
                int temp = nums[tail];
                nums[tail] = nums[head];
                nums[head] = temp;
                tail--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        int[] res = sortArrayByParity(nums);
        System.out.println(Arrays.stream(res).iterator());
    }
}
