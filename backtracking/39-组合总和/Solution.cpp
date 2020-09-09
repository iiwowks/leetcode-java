/*
 * @lc app=leetcode.cn id=39 lang=cpp
 *
 * [39] 组合总和
 */

// @lc code=start
#include <vector>
using namespace std;

class Solution
{
public:
    void dfs(vector<int> &candidates, int target, vector<vector<int>> &ans, vector<int> &combine, int index) {
        if (index == candidates.size()) {
            return;
        }
        if (target == 0) {
            ans.emplace_back(combine);
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, index + 1);
        // 选择当前数
        if (target - candidates[index] >= 0) {
            combine.emplace_back(candidates[index]);
            dfs(candidates, target - candidates[index], ans, combine, index);
            combine.pop_back();
        }
    }

    vector<vector<int>> combinationSum(vector<int> &candidates, int target) {
        vector<vector<int>> ans;
        vector<int> combine;
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }
};
// @lc code=end
