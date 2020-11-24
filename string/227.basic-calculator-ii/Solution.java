/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        int len = s.length();
        if (s == null || len == 0) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        int currentNum = 0;
        char operation = '+';
        
        for (int i= 0; i < len; i++) {
            char currentChar = s.charAt(i);
            
            if (Character.isDigit(currentChar)) {
                currentNum = (currentNum * 10) + (currentChar - '0');
            }
            
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNum);
                }
                else if (operation == '+') {
                    stack.push(currentNum);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * currentNum);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / currentNum);
                }
                operation = currentChar;
                currentNum = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
// @lc code=end

