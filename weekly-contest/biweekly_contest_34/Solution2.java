/* 
 * 5492. 分割字符串的方案数
 */

class Solution2 {
    public int numWays(String s) {
        Double temp = Math.pow(10, 9);

        double mod = temp.intValue() + 7;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if ('1' == s.charAt(i)) {
                list.add(i);
            }
        }
        if (list.size() % 3 != 0) {
            return 0;
        }
        int c = list.size() / 3;
        if (c == 0) {
            double k = s.length() - 2;

            Double res1 = k * (k + 1) / 2 % mod;
            return res1.intValue();
        }
        double lc = list.get(c) - list.get(c - 1);
        double rc = list.get(2 * c) -list.get(2 * c - 1);

        Double res = lc * rc % mod;
        return res.intValue();
    }
}