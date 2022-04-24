public class Demo394 {

    public static int maxRotateFunction(int[] nums) {
        int length = nums.length;
        int max = 0;

        for (int i = 0; i < length; i++) {
            int fNum = 0;
            for (int j = 0; j < length; j++) {
                int send = (length - (i - j)) % length;
                fNum += nums[send] * j;
            }
            if (fNum > max) max = fNum;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,6};
        int max = maxRotateFunction(nums);
        System.out.println(max);
    }
}
