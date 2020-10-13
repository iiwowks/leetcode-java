
/**
 * [5523. 文件夹操作日志搜集器] 
 * 
 */
import java.util.regex.*;
import java.util.Stack;

class Solution1 {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        String pattern = "\\w*" + "//";
        for (int i = 0; i < logs.length; i++) {
            if (Pattern.matches(pattern, logs[i])) {
                stack.push(logs[i]);
            }
            if (logs[i] == "./") {
                continue;
            }
            if (logs[i] == "../") {
                stack.pop();
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            stack.pop();
            res++;
        }
        return res;
    }
}
