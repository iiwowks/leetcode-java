/**
 * 1576. 替换所有的问号
 * I can't solve this problem
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符
 * 
 */

class Solution1 {
    public String modifyString(String s) {
        // 转数组
        char[] sChar = s.toCharArray();
        for (int i = 0; i <sChar.length; i++) {
            if (sChar[i] != '?') {
                continue;
            }
            char c = 'a';
            while (i != 0 && sChar[i - 1] == c || i + 1 < sChar.length && sChar[i + 1] == c) {
                c++;
            }
            sChar[i] = c;
        }
        // 转回String
        return String.valueOf(sChar);
    }
}
