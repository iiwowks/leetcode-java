import java.util.Set;
import java.util.HashSet;
/**
 * [1587. 拆分字符串使唯一子字符串的数目最大]
 * 拆分字符串s，拆分后可以得到若干 非空子字符串
 * 输入：s = "ababccc"
 * 输出：5
 * 解释：一种最大拆分方法为 ['a', 'b', 'ab', 'c', 'cc'] 。
 * 像 ['a', 'b', 'a', 'b', 'c', 'cc'] 这样拆分不满足题目要求，
 * 因为其中的 'a' 和 'b' 都出现了不止一次。
 */
class Solution2 {
    int max = 0;
    Set<String> set = new HashSet<>();
    
    public int maxUniqueSplit(String s) {
        dfs(s, 0, 0, 1);
        return max;
    }

    /**
     * 
     * @param s
     * @param start
     * @param end
     * @param res
     */
    private void dfs(String s, int start, int end, int res) {
        // 出口
        if (end == s.length() - 1) {
            if (set.contains(s.substring(start, end + 1))) {
                return;
            } else {
                max = Math.max(max, res);
                return;
            }
        }
        String cur = s.substring(start, end + 1);
        // 选择在end位置后切
        if (!set.contains(cur)) {
            set.add(cur);
            dfs(s, end + 1, end + 1, res + 1);
            set.remove(cur);
        }
        // end位置后不切
        dfs(s, start, end + 1, res);
    }
}