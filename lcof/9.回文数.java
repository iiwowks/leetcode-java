/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        //边界判断
        if(x<0) return false;
        int div=1;
        while(x/div>=10) div*=10;
        while(x>0){
            int left=x/div;
            int right=x%10;
            if(left!=right) return false;
            //抹除最高位和最低位
            x=(x%div)/10;
            //div变成   原来最高位数-2
            div/=100;
        }        
        return true;
    }
}
// @lc code=end

