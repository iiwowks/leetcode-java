
// put solution class below
class Solution2 {
    static int divSum(int num) {
        int result = 0;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i == (num / i) && i < 30000000)
                    result += i;
                else if (i + num / i < 30000000)
                    result += (i + num / i);
            }
        }
        return (result + 1);
    }

    // main test
    public static void main(String[] args) {

        Solution2 solution = new Solution2();
        int res = solution.divSum(1234567890);
        // write test case
        System.out.println(res);
    }
}