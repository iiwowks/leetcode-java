/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 * 解题思路：
 * 1. 排序两个数组
 * 2. 从小到大比较，贪心解决
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for  (int j = 0; res < g.length && j < s.length; j++) {
            if (g[res] <= s[j]) res++;
        }
        return res;
    }
}
// @lc code=end

