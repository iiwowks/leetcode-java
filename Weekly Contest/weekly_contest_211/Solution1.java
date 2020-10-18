/**
 * [5543. 两个相同字符之间的最长子字符串] 
 * 
 */

class Solution1 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            int lastIndex = s.lastIndexOf(s.charAt(i));
            if (lastIndex > i) {
                res = Math.max(res, lastIndex - i - 1);
            }
        }
        return res;
    }
}
