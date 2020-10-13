/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串： 判断s是否可以由长度为n`的子串s`重复多次构成
 */

// @lc code=start
// 方法二：字符串匹配
class Solution2 {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
// @lc code=end

