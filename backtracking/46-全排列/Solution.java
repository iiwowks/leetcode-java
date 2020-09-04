import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列：给定一个没有重复 数字的序列，返回其所有可能的全排列
 * 
 */

// @lc code=start
class Solution {
    /*
     * 在这个位置书写的变量为成员变量 有些时候判断是写成成员变量好还是 直接传参好
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i]))
                    continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
// @lc code=end

