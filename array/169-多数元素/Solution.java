/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 * 找到数组中出现次数大于 n/2 的元素
 * 方法一： 排序
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
// @lc code=end

