/*
 * @lc app=leetcode.cn id=679 lang=java
 *
 * [679] 24 点游戏： 给定4个数字（1~9），判断是否可以通过 *,/,+,- 的运算得到24
 */

// @lc code=start
// 解题思路：回溯 ：一共有12*4*6*4*2*4种可能性，通过回溯的方法遍历所有不同的可能性。
class Solution {
    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<Double>();
        // 使用一个列表存储目前全部数字，每次从列表中选出2个数字，在选择1种运算操作
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }

    public boolean solve(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }
        int size = list.size();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // 选取两个不同的数字
                if (i != j) {
                    List<Double> list2 = new ArrayList<Double>();

                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            list2.add(list.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j) {
                            continue;
                        }
                        if (k == ADD) {
                            list2.add(list.get(i) + list.get(j));
                        } else if (k == MULTIPLY) {
                            list2.add(list.get(i) * list.get(j));
                        } else if (k == SUBTRACT) {
                            list2.add(list.get(i) - list.get(j));
                        } else if (k == DIVIDE) {
                            if (Math.abs(list.get(j)) < EPSILON) {
                                continue;
                            } else {
                                list2.add(list.get(i) / list.get(j));
                            }
                        }
                        if (solve(list2)) {
                            return true;
                        }
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}
// @lc code=end
