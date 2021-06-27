package test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhengjunan on 2021/6/7.
 */
public class Solution {

    /**
     * 問題1
     * 約数ぜんぶ足す
     * 1234567890の正の約数のうち、10000000以下のものを全て足し合わせたときの和を求めてください。
     */
    public void problem1() {
        int sum = 0;
        for (int i = 1; i < 10000000; i++) {
            if (1234567890 % i == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }


    /**
     * 問題2
     * トリボナッチ数列
     * 以下のような規則で整数を並べます。
     *
     * 最初の3つの数は「1, 0, 5」である。
     * それ以降は、直前の3つの整数の和を並べる。つまり、
     * 4番目の整数は 1 + 0 + 5 = 6
     * 5番目の整数は 0 + 5 + 6 = 11
     * 6番目の整数は 5 + 6 + 11 = 22
     * この規則により、次のような列ができます。
     *
     * 1, 0, 5, 6, 11, 22, 39
     *
     * この列の31番目の整数を求めてください。
     */
    public int problem2(int n) {
        if(n == 0) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 5;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i - 3];
            dp[i] %= 1000000007;
        }
        System.out.println(dp[n]);
        return dp[n];
    }

    /**
     * 問題3
     * 3の倍数と3のつく数字だけ
     * 次の条件の少なくとも一方を満たす整数のことを「A的な数」と呼ぶことにします。
     * 3の倍数である。
     * 十進法で書いた場合に「3」が含まれる。
     * 例えば、9、31、42、135は何れも「A的な数」です。
     * 1から30000までの整数のうち「A的な数」だけを足し合わせたときの合計を求めてください。
     */
    public void problem3() {
        int count = 0;
        for (int i = 1; i <= 30000; i++) {
            if (helper3(i)) {
                count += i;
            }
        }
        System.out.println(count);
    }

    public boolean helper3(int num) {
        int sum = 0;
        while (num != 0) {
            if (num % 10 == 3) {
                return true;
            } else {
                sum = sum + num % 10;
                num = num / 10;
            }
        }
        if (sum % 3 == 0) {
            return true;
        }
        return false;
    }


    /**
     * 問題4
     * 荷物がいっぱいです
     * ここに600個の荷物があり、それぞれの重さは1kg、2kg、3kg、……、600kgとなっています。これらを最大積載量5000kgのトラックを何台か使って運ぼうとしています。
     *
     * トラックに荷物を載せるのに、次のような方針を立てました。
     *
     * 重い荷物から順にトラックに載せていく。
     * ある荷物を載せると最大積載量を超えてしまう場合は、新しいトラックを用意してそちらに載せる。古いほうのトラックには以降は新しい荷物は載せない。
     * この方針に従うと、
     *
     * 1台目のトラックには600kg，599kg，598kg，597kg，596kg，595kg，594kg，593kgの荷物が載せられる。
     * 2台目のトラックには592kg，591kg，590kg，589kg，588kg，587kg，586kg，585kgの荷物が載せられる。
     * となります。最終的に何台のトラックが必要になるかを求めてください。
     */
    public void problem4() {
        int count = 0;
        for (int i = 600; i >= 1;) {
            int temp = 0;

            while (temp <= 5000 && i >= 1) {
                temp += i;
                if (temp > 5000) {
                    break;
                }
                System.out.print(i + ", ");
                i--;
            }
            System.out.println("");
            count++;
        }
        System.out.println(count);
    }


    /**
     * 問題5
     * 切手・切手・切手
     * 205円切手が30枚、82円切手が40枚、30円切手が10枚あります。
     * これらの切手の全部または一部（1枚以上）を使って額面の和として表せる金額は何通りあるか、求めてください。
     */
    public void problem5() {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i <= 30; i++) {
            for (int j = 0; j <= 40; j++) {
                for (int z = 0; z <= 10; z++) {
                    res.add(205 * i + 82 * j + 30 * z);
                }
            }
        }
        System.out.println(res.size() - 1);
    }

    /**
     * 問題6
     * ピタゴラスな三角形
     * 三辺の長さが3，4，5である三角形は直角三角形です。これは「ピタゴラスの定理」から示されます。
     *
     * 【ピタゴラスの定理】 直角三角形について、直角をはさむ2辺の長さがaとbで斜辺の長さがcであるとき a^2 + b^2 = c^2 が成り立つ。
     *
     * 三辺の長さが整数で面積が8192以下である直角三角形は何種類あるかを求めてください。
     *
     * ※合同なもの（例えば“3，4，5”と“5，4，3”）は区別せず1種類として数えます。
     */
    public void problem6() {
        int count = 0;
        for (int i = 1; i < 8200; i++) {
            for (int j = i; j < 8200; j++) {
                double temp2 = Math.sqrt(i * i + j * j);
                int temp1 = (int)temp2;

                // check temp1 is a integer
                if (temp1 == temp2) {
                    if (i * j / 2 < 8192) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }


    /**
     *  問題7
     *  A->Z matrix
     *
     */
    public void problem7() {
        int[][] matrix = new int[36][36];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int index = 1;
        while(true) {
            for(int i = l; i <= r; i++) matrix[t][i] = index++ % 26; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) matrix[i][r] = index++ % 26; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) matrix[b][i] = index++ % 26; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) matrix[i][l] = index++ % 26; // bottom to top.
            if(++l > r) break;
        }
        for (int i = 0; i < 36; i++) {
            System.out.print((char)(matrix[i][i] - 1 + (int)'A'));
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.problem1();
        solution.problem2(30);
        solution.problem3();
        solution.problem4();
        solution.problem5();
        solution.problem6();
        solution.problem7();
    }
}
