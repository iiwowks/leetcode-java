/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.empty()) { // 若栈1为空，此时front = x;
            front = x;
        }
        while (!s1.isEmpty()) { // 若栈1非空，将所有元素移动到栈2
            s2.push(s1.pop());
        }
        s2.push(x); // 将新元素入栈
        while (!s2.isEmpty()) { // 将栈2所有元素移动到栈1
            s1.push(s2.pop());
        }

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int res = s1.pop();
        if (!s1.isEmpty()) {
            front = s1.peek();
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

