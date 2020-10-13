/**
 * LCP 17. 速算机器人
 */
class Solution1 {
    public int calculate(String s) {
        int x = 1, y = 0;
        char[] schar = s.toCharArray();
        
        for (int i = 0; i < schar.length; i++) {
            if (schar[i] == 'A') {
                x = x * 2 + y;
            } else if (schar[i] == 'B') {
                y = y * 2 + x;
            }
        }
        return x + y;
    }
}
