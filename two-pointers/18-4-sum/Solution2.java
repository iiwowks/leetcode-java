
class Solution2 {
    int len = 0;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        // 升序排列
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }
    
    public List<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (index >= len) {
            return res;
        }
        // 二数之和
        if (k == 2) {
            int i = index, j = len - 1;
            while (i < j) {
                if (target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(target - nums[i]);
                    res.add(temp);
                    // 去重
                    while (i < j && nums[i] == nums[i + 1]) i++;
                    while (i < j && nums[j - 1] == nums[j]) j--;
                    i++;
                    j--;
                }
                else if (target - nums[i] > nums[j]) {
                    i++;
                }
                else {
                    j--;
                }
            }
        }
        // 
        else {
            for (int i = index; i < len - k + 1; i++) {
                // 用当前的数，将kSum 转换成 k - 1Sum
                List<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
                if (temp != null) {
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < len - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }
}
