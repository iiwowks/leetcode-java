/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
// 使用哈希表
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Boolean> hashTable = new HashMap<Integer, Boolean>();

        for (int i = 0; i < nums.length; i++) {
            hashTable.put(nums[i], true);
        }
        List<Integer> result = new LinkedList<Integer>();

        for (int i = 1; i <= nums.length; i++) {
            if (!hashTable.containsKey(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
// @lc code=end

