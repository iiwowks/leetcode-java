class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1)
            return false;
        int sum = 1;
        int i = 2;
        double sqrt = Math.sqrt(num);
        for (; i < sqrt; i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        if (i * i == num)
            sum += i;
        return sum == num;

    }
}