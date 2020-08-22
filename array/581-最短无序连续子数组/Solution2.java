/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
// 解题思路：排序：比较排序前后两个数组的最左边和最右边不匹配的元素。
class Solution2 {
    public int findUnsortedSubarray(int[] nums) {
        int[] sums = nums.clone();
        Arrays.sort(sums);
        int start = sums.length, end = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);      
    }
}
// @lc code=end

