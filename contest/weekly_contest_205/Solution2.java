/**
 * 5508. 数的平方等于两数乘积的方法数
 * 给你两个整数数组 nums1 和 nums2 ，请你返回根据以下规则形成的三元组的数目（类型 1 和类型 2 ）：
 *
 * 类型 1：三元组 (i, j, k) ，如果 nums1[i]2 == nums2[j] * nums2[k] 其中 0 <= i < nums1.length 且 0 <= j < k < nums2.length
 * 类型 2：三元组 (i, j, k) ，如果 nums2[i]2 == nums1[j] * nums1[k] 其中 0 <= i < nums2.length 且 0 <= j < k < nums1.length
 * 
 * 解题思路：
 * 1. 用map 存储第一个数组第i个元素和第j个元素乘积
 * 2. 遍历第二个数组每个元素的平方，在map中是否存在
 * 3. Int 类型数字会溢出，Int转Long
 * long temp = (long)43024 * (long)99908 ==> 4298441792
 */

class Solution2 {
    public int numTriplets(int[] nums1, int[] nums2) {
        return function(nums1, nums2) + function(nums2, nums1);
    }

    public int function(int[] nums1, int[] nums2) {
        int res = 0;
        if (nums1.length < 2) {
            return res;
        }
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length - 1; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                long temp = (long) nums1[i] * (long) nums1[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            long temp = (long)nums2[i] * (long)nums2[i];
            if (map.containsKey(temp)){
                res += map.get(temp);
            }
        }
        return res;
    }
}
