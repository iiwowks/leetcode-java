/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合：给定数字2-9的字符串，返回所有能表示的字母组合
 */

// 方法一：回溯
// 1. 在回溯过程中，维护一个字符串表示已有的字母排列
// @lc code=start
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// test solution class
class Main {

    public static void main(final String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.letterCombinations("23");
        // write test case
        System.out.println(res);

    }
}

// put solution class below
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    // 在当前的index(表示当前遍历到了哪一位)基础上回溯穷举
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {

            char digit = digits.charAt(index); // index位置表示的数字char
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();

            for (int i = 0; i < lettersCount; i++) { // 遍历：对应"abc || def..."的字符串字母，每次遍历一个字母就递归调用backtrack(..., index + 1, ...)
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);

                combination.deleteCharAt(index); // 删除最后一个字符，保持本层combination不变，继续回溯调用backtrack
            }
        }
    }
}

// @lc code=end

