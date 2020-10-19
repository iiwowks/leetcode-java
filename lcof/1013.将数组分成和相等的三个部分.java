/*
 * @lc app=leetcode.cn id=1013 lang=java
 *
 * [1013] 将数组分成和相等的三个部分
 * 思路：首选算A的累加和能否被3整除，不可以那分不了3等分。
    双指针前后向中间逼近，不用考虑中间那段怎么分，
    只要左右两段累加和等于3等分的数值，中间剩的那段也就找到了。
 */

// @lc code=start
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i : A){
            sum +=i;
        }
        if (sum%3 != 0) return false;
        //双指针前后逼近
        int left = 0,right = A.length-1;
        int leftSum = A[left];
        int rightSum = A[right];

        while(left+1 < right){
            if(leftSum == sum/3 && rightSum == sum/3){
                return true;
            }
            if(leftSum !=sum/3){
                leftSum+=A[++left];
            }
            if(rightSum !=sum/3){
                rightSum +=A[--right];
            }
        }
        return false;
    }
}
// @lc code=end

