/**
 * 848
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
 *
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-gap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Demo868 {
    public static int binaryGap(int n) {
        String s1 = Integer.toBinaryString(n);
        int cur = 0;
        int next = 0;
        int bound;
        int max = 0;
        char[] chars = s1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1' && next == 0) {
                cur = i;
                next = 1;
            } else if (chars[i] == '1' && next == 1) {
                bound = i - cur;
                if (bound > max) max = bound;
                cur = i;
            }
        }
        return max;
    }

    /**
     * 主要考察位运算  n的左移右移 位运算符号 & 与 <<
     * @param n
     * @return
     */
    public static int binaryGapAns(int n) {
        int last = -1, ans = 0;
        for (int i = 0; n != 0; ++i) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 22;
        int max = binaryGapAns(n);
        System.out.println(max);
    }
}
