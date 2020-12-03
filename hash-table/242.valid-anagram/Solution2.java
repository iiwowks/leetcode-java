/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
// 方法2: 哈希 + 计数
class Solution2 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character chars : s.toCharArray()) {
            map.put(chars, map.getOrDefault(chars, 0) + 1);
        }
        for (Character chart : t.toCharArray()) {
            map.put(chart, map.getOrDefault(chart, 0) - 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) return false;
        }
        return true;
    }
}
// @lc code=end

