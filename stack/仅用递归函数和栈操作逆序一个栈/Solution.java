// 转置一个栈，只使用递归函数实现，不能用其它数据结构
// 方法一：将stack的栈底元素返回并移除

class Solution {
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            // 此时栈为空，这一层的result 为栈底元素
            int last = getAndRemoveLastElement(stack); 
            stack.push(result);
            return last;
        }
    }
}