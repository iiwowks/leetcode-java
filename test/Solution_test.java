import java.util.ArrayList;
import java.util.List;

// test solution class
class Main {

    public static void main(final String[] args) {
        Solution_test solution = new Solution_test();
        boolean res = solution.isHappy(7);
        // write test case
        System.out.println(res);

    }
}

// put solution class below
public class Solution_test {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        final List<Integer> res = new ArrayList<Integer>();
        while (n != 0) {
            res.add(n % 10);
            n /= 10;
        }
        int temp = 0;
        for (int i = 0; i < res.size(); i++) {
            temp += res.get(i) * res.get(i);
        }
        return isHappy(temp);
    }
}
