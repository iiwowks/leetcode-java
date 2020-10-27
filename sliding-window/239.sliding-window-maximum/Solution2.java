/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// 方法二：双向队列：
// 1. 处理前k个元素，初始化双向队列
// 2. 遍历整个数组，在每一步:
//      2.5. 清理双向队列：
        // 只保留滑动窗口中所有元素的索引
        // 移除比当前元素小的所有元素，不可能是最大的元素
// 3. 将当前元素添加到双向队列中。
// 4. 将 deque[0] 添加到输出中。
// 5. 返回输出数组


// @lc code=start
class Solution {
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;

    public void clean_deque(int i, int k) {
        if (!deq.isEmpty() && deq.getFirst() == i - k) { // i - k 代表第一个索引
            deq.removeFirst(); // 
        }
        // 比nums[i]小进队列
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.removeLast();
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        // 初始化队列
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // 记录最大值在nums[:k]中的下标
            if (nums[i] > nums[max_idx]) max_idx = i;
        }
        int[] output = new int[n - k + 1];
        output[0] = nums[max_idx];
        
        //
        for (int i = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

}
// @lc code=end

