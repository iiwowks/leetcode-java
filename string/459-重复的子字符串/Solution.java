/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串： 判断s是否可以由长度为n`的子串s`重复多次构成
 */

// @lc code=start
// 方法一：枚举
//         1. n 是 n` 的倍数
//         2. s` 是 s 的前缀
//         3. 对于任意的 n` <= i < n, 有 s[i] = s[i - n`];

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

