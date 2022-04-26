package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 */
public class Demo1 {

    /**
     * 常规的暴力匹配
     * 时间复杂度O(n2) 空间复杂度O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Boolean cur = false;
        for (int i = 0; i < nums.length; i++){
            int bound = i + 1;
            if (cur) break;
            while(bound < nums.length){
                if (nums[i] + nums[bound] == target){
                    res[0] = i;
                    res[1] = bound;
                    cur = true;
                    break;
                }else {
                    bound ++;
                }
            }
        }
        return res;
    }

    /**
     * hash表
     * 时间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

}
