/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String[] strArray = s.split(" ");
        StringBuilder result = new StringBuilder();
        int n = strArray.length;
        for (int i = 0; i < n; ++i) {
            StringBuilder sb = new StringBuilder(strArray[i]);
            result.append(sb.reverse());
            if (i < n - 1) result.append(" ");
        }
        return result.toString();
    }
}
// @lc code=end

