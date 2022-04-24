/**
 * 设两个字符串分别为 ss 和 \textit{goal}goal，其中 s[i]s[i] 表示 ss 的第 ii 个字符，其中 \textit{goal}[i]goal[i] 表示 \textit{goal}goal 的第 ii 个字符。如果 s[i] = \textit{goal}[i]s[i]=goal[i]，我们就说 ii 是匹配的，否则称 ii 是不匹配的。亲密字符串定义为：需要交换 ss 中的第 ii 个字符 s[i]s[i] 与 \textit{s}s 中第 jj 个字符且满足 i \neq ji
 * 
 * ​
 *  =j，交换后 ss 与 \textit{goal}goal 相等。亲密字符串的两个字符串需要交换一次索引不相等的两个字符后相等。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/buddy-strings/solution/qin-mi-zi-fu-chuan-by-leetcode-solution-yyis/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Demo859 {

    public boolean buddyStrings(String s, String goal) {

        // 两字符串相等的case
        if (s.equals(goal)) {
            int[] count = new int[26];  // 建立一个26个字母的索引
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;   // 对应字母频度统计
                if (count[s.charAt(i) - 'a'] > 1) {   // 如果有大于1的，就一定有重复字母，因为两字符串相等，所以换重复的就一定相等
                    return true;
                }
            }
            return false;
        } else {
            // 两字符串不相等的情况
            int first = -1, second = -1;
            for (int i = 0; i < goal.length(); i++) {  // 遍历字符串
                if (s.charAt(i) != goal.charAt(i)) {  // 判断有且仅有两个s和goal相同位置的字符不一样，一个first, 一个second
                    if (first == -1)
                        first = i;   // 找到first
                    else if (second == -1)
                        second = i;   // 找到second
                    else
                        return false;   // 超过两个
                }
            }
            //second != -1 first也就不是-1了，满足有且仅有两个不同字符
            //s的first等于goal的second且s的second等于goal的first,互换可得相同字符串
            return (second != -1 && s.charAt(first) == goal.charAt(second) &&
                    s.charAt(second) == goal.charAt(first));
        }

    }

    public static void main(String[] args) {

    }
}
