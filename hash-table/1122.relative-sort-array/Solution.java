/*
 * @lc app=leetcode id=1122 lang=java
 *
 * [1122] Relative Sort Array (数组的相对排序)
 * 1. 自定义排序：
 *    把 array2 的 {arr2[i], i} 存进哈希表中，对于元素x, y:
 *    case 1: 如果x，y都在哈希表中，比较rank[x], rank[y]
 *    case 2: 都不在，比较自身
 *    case 3: 出现在哈希表中的元素较小
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            list.add(num);
        }
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        Collections.sort(list, (x, y) -> {
            if (map.containsKey(x) || map.containsKey(y)) {
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            }
            return x - y;
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }
}
// @lc code=end

