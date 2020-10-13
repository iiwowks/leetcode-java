import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 *  给定一个非空的整数数组，返回其中出现频率前k高的元素
 * 
 * 解题思路： 
 * 在这里，我们可以利用堆的思想：建立一个小顶堆，然后遍历「出现次数数组」：
 * 如果堆的元素个数小于 k，就可以直接插入堆中。
 * 如果堆的元素个数等于 k，则检查堆顶与当前出现次数的大小。如果堆顶更大，说明至少有 k 个数字的出现次数比当前值大，故舍弃当前值；
 * 否则，就弹出堆顶，并将当前值插入堆中。
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // key - value
        Map<Integer, Integer> occurences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurences.put(num, occurences.getOrDefault(num, 0) + 1);
        }
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        //
        for (Map.Entry<Integer, Integer> entry : occurences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
// @lc code=end

