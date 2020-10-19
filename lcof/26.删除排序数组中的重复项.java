/*
 * @lc app=leetcode.cn id=26 lang=java
 *  双指针法： i是慢指针，j是快指针
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {

                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}

class Solution_2 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
// @lc code=end
