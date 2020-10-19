/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;
    }
}
class Solution_2{
    public int longestPalindrome(String s){
        int[] cnt  = new int[58];
        for(char c: s.toCharArray()){
            cnt[c - 'A'] +=1;
        }
        int ans = 0;
        for(int x: cnt){
            ans +=x - (x&1);
        }
        return ans < s.length() ? ans+1 : ans;
    }
}
// @lc code=end

