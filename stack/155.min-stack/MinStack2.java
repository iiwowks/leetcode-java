/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// 方法二：辅助栈和数据栈不同步
// 1. 辅助栈的元素为空的时候，必须放入新进来的数
// 2. 新来的数 <= 辅助栈顶元素时，放入
// 3. 出栈时，辅助栈栈顶元素 == 数据栈栈顶元素，出栈
// @lc code=start
class MinStack2 {
    private Stack<Integer> data;
    private Stack<Integer> helper;

    public MinStack2() {
        data = new Stack<>();
        helper = new Stack<>();
    }
    public void push(int x) {
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        }
    }
    public void pop() {
        if (!data.isEmpty()) {
            int top = data.pop();
            if (top == helper.peek()) {
                helper.pop();
            }
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

