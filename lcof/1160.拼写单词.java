import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1160 lang=java
 *
 * [1160] 拼写单词
 */

// @lc code=start
class Solution {
    public int countCharacters(String[] words, String chars) {
        int count = 0;
        int[] seen = new int[26];
        for(char c: chars.toCharArray()) seen[c - 'a']++;
        for(String word : words){
            int[] tSeen = Arrays.copyOf(seen, seen.length);
            int Tcount = 0;
            for(char c : word.toCharArray()){
                if(tSeen[c - 'a'] > 0){
                    tSeen[c - 'a']--;
                    Tcount++;
                }
            }
            if(Tcount == word.length()) count +=Tcount;
        }
        return count;
}
class Solution_2 {
    public int countCharacters(String[] words, String chars) {
        int[] c = new int[26];
        for(char cc : chars.toCharArray()) {
            c[(cc - 'a')] += 1;
        }
        int res = 0;
        a: for(String word : words) {
            int[] w = new int[26];
            for(char ww : word.toCharArray()) {
                w[(ww - 'a')] += 1;
            }
            for(int i=0; i<26; i++) {
                if(w[i] > c[i]) {
                    continue a;
                }
            }
            res += word.length();
        }
        return res;
    }
}



// @lc code=end

