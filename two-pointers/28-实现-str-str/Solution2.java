/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr(): 在haystack字符串中找到needle字符串出现的第一个位置，不存在返回-1
 */

// @lc code=start
// 方法二：双指针
class Solution {
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;
        int pn = 0;
        while (pn < n - L + 1) {
            // 找到第一个字符位置
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;
            // 初始化currlen和pL
            int currlen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pL;
                ++pn;
                ++currlen;
            }
            if (currlen == L) return pn - L; // 找到了全部needle
            // 回溯
            pn = pn - currlen + 1;
        }
        return -1;
    }
}
// @lc code=end

