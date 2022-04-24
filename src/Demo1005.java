import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 *
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 *
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Demo1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        ArrayList<Integer> minus = new ArrayList<>();
        for (int i = 0; i < nums.length; i++ ) {
            if (nums[i] < 0) {
                int temp = nums[i];
                nums[i] = -temp;
                k--;
            }
        }
        int res = Arrays.stream(nums).sum();

        if (k > 0){
            if (k % 2 == 1){
                int min = Arrays.stream(nums).min().getAsInt();
                res = res - 2 * min;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,-3,-1,5,-4};
        int k = 2;
        Demo1005 demo = new Demo1005();
        System.out.println(demo.largestSumAfterKNegations(nums,k));
    }
}
