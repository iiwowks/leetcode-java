/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// 方法一：辅助栈和数据栈同步
// @lc code=start
class MinStack {
    private Stack<Integer> data;    // 数据栈
    private Stack<Integer> helper;  // 辅助栈

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int x) {
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        } else {
            helper.add(helper.peek());
        }
    }
    
    public void pop() {
        if (!data.isEmpty()) {
            helper.pop();
            data.pop();
        }
    }
    
    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if (!helper.isEmpty()) {
            return helper.peek();
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

