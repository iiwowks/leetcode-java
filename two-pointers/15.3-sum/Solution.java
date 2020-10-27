/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */
// 找到三元组，和为零。返回三元组集合 
// 重点：去重，保持不重复
// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 2)
            return res;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break;
            // 去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;

            //
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
// @lc code=end

