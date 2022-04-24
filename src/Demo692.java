import java.util.HashMap;
import java.util.List;

public class Demo692 {

    public static int[][] getPoint(int[] nums){
        int[][] points = new int[nums.length][2];
        int cur = 0;
        for (int i = 1;i < nums.length; i++){
            points[cur][0] = i;
            points[cur][1] = nums[i];
            cur++;
        }
        return points;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int[][] points = getPoint(nums);
    }
}
