/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 * 解题思路：贪心 + 双指针:
 *  每个字母第一次出现，最后一次出现的下标必须在同一片段
 *  遍历字符串，记录每一个字母出现的最后的下标
 * 
 * 1. 遍历字符串，维护当前片段下标start, end
 * 2. 对于每一个字母 c，找到其最后出现的下标end_c，end = max(end, end_c)
 * 3. 访问到 end时，结束当前片段， start = end + 1
 * 4. 重复以上步骤，直至遍历完整个字符串
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        //
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        // 当前片段
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            // end = max(end , end_c)
            end = Math.max(end, last[S.charAt(i) - 'a']);
            // i 走到当前片段末尾
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
// @lc code=end

