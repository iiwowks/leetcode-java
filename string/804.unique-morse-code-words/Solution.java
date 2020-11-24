/*
 * @lc app=leetcode id=804 lang=java
 *
 * [804] Unique Morse Code Words
 */

// @lc code=start
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Map<Character, String> map = new HashMap<>();
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        for (int i = 0; i < 26; i++) {
            map.put((char)('a' + i), morse[i]);
        }
        Set<String> set = new HashSet<>();
        for (String s : words) {
            String temp = "";
            for (char c : s.toCharArray()) {
                temp += map.get(c);
            }
            set.add(temp);
        }
        return set.size();
    }
}
// @lc code=end

