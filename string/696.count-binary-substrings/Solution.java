/*
 * @lc app=leetcode id=696 lang=java
 *
 * [696] Count Binary Substrings
 */

// @lc code=start
class Solution {
    /**
     * 
     * @param counts: 需要构造的{}数组
     * @return
     */
    public int countBinarySubstrings(String s) {
        // {}数组
        List<Integer> counts = new ArrayList<Integer>();
        int ptr = 0, n = s.length();
        // 构造{}数组
        while(ptr < n) {
            char c  = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }
}
// @lc code=end

