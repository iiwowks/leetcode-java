/**
 * [1678. Goal Parser Interpretation] 
 * 题意：将一行字符串中的特定字符转译
 * G -> G
 * () -> o
 * (al) -> al
 * 正则表达式：
 * \\(\\) -> 0
 * \\(al\\) -> al
 */
class Solution1 {
    public String interpret(String command) {
        return command.replaceAll("\\(\\)", "o").replaceAll("\\(al\\)", "al");
    }
}
