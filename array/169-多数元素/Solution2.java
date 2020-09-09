import java.util.Map;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 * 找到数组中出现次数大于 n/2 的元素
 * 方法二： 使用哈希表存储每个元素及其出现次数。元素 - 出现次数
 */

// @lc code=start
class Solution {
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        return counts;
    }
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);
        Map.Entry<Integer, Integer> majorEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorEntry == null || entry.getValue() > majorEntry.getValue()) {
                majorEntry = entry;
            }
        }
        return majorEntry.getKey();
    }
}
// @lc code=end

