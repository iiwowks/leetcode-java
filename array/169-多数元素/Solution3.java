import java.util.Map;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 * 找到数组中出现次数大于 n/2 的元素
 * 方法三：摩尔投票法: 遇到相同的数就投一票，遇到不同的数就减1票，最后还存在的数就是众数
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, result = 1;
        for (int num : nums) {
            if (count == 0) result = num;
            if (num == result) ++count;
            else --count;
        }
        return result;
    }
}
// @lc code=end

