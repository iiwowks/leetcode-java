/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
// 方法二：中心拓展算法
// 本质：枚举所有的"回文中心"并尝试"拓展",直到无法拓展为止，此时的回文串长度即为此"回文中心"下的最长回文串长度
//       对所有的长度求最大值，得到最终的答案
class Solution2 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        // 
        for (int i = 0; i < s.length(); i++) {
            //  边缘状态1：
            int len1 = expandAroundCenter(s, i, i);
            //  边缘状态2:
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2); // 在两种状态中选择长度最长的一种
            //  更新 start end
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }
        return s.substring(start, end + 1);
    }

    // 返回s字符串对应位置能拓展出去的最大长度
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}

// @lc code=end

