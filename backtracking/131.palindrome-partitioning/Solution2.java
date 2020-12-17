/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution2 {
   public List<List<String>> partition(String s) {
       List<List<String>> res = new ArrayList<>();
       dfs(0, res, new ArrayList<String>(), s);
       return res;
   }
   
   public void dfs(int start, List<List<String>> res, List<String> temp, String s) {
       if (start >= s.length()) {
           res.add(new ArrayList<String>(temp));
       }
       for (int end = start; end < s.length(); end++) {
           if (isPalindrome(s, start, end)) {
               temp.add(s.substring(start, end + 1));
               dfs(end + 1, res, temp, s);
               temp.remove(temp.size() - 1);
           }
       }
   }
   
   public boolean isPalindrome(String s, int start, int end) {
       while (start < end) {
           if (s.charAt(start++) != s.charAt(end--)) return false;
       }
       return true;
   }
}
// @lc code=end

