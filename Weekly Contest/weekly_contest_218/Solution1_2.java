/**
 * [1678. Goal Parser Interpretation] 
 * 题意：将一行字符串中的特定字符转译
 * G -> G
 * () -> o
 * (al) -> al
 */
class Solution1_2 {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
            } else if (i + 1 < command.length() && command.charAt(i + 1) == ')') {
                sb.append('o');
                i++;
            } else {
                sb.append("al");
                i = i + 3;
            }
        }
        return sb.toString();
    }
}
