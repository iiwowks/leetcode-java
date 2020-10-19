/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start

import java.util.Map;
import java.util.HashMap;

class Solution {
    //使用哈希映射表
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }
    //同时遍历 key 和 value 可以使用 for each循环遍历Map对象的entrySet()集合，它包含每一个key-value映射
    // Map.Entry<K,V> 
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> counts = countNums(nums);
        
        Map.Entry<Integer, Integer> majorityEntry = null;
        
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()){
            
            if(majorityEntry == null || entry.getValue() > majorityEntry.getValue()){
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }
}
// @lc code=end
