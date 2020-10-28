/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    /**
     * 
     * @param list  result
     * @param str   temp result
     * @param open  number of '('
     * @param close number of ')'
     * @param max   usable number of parenthesis pairs
     */
    public void backtrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        // 已使用左括号小于max时
        if (open < max) {
            backtrack(list, str + "(", open + 1, close, max);
        }
        // 已使用左括号 大于 已使用右括号时
        if (close < open) {
            backtrack(list, str + ")", open, close + 1, max);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
}
// @lc code=end
