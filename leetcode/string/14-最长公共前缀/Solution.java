/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
// 方法一：横向扫描
// 对于每一个遍历到的字符串，更新最长公共前缀，当遍历完所有的字符串之后，即可得到字符串数组中的最长公共前缀
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        // 逐个字符串比较
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            // 如果最长字串长度为零，就不需要继续比较下去了
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }
    // 单个字符串比较：将当前的最长公共前缀与后面的String依次比较，并更新
    public String longestCommonPrefix(String str1, String str2) {
        // 最短字符串长度
        int length = Math.min(str1.length(), str2.length());
        // 开始
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)){
            index++;
        }   
        return str1.substring(0, index);
    } 
}
// @lc code=end

