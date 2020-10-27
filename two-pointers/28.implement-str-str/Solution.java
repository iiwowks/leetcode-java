/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
// 方法一：子串逐一比较
class Solution {
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        
        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}
// @lc code=end

