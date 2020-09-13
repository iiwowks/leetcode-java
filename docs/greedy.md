## 贪心算法

贪心算法是在每一步选择中都采取在当前状态下最好或最优（最有利）的选择，从而希望导致结果是全局最好或最优的算法。

* **贪心：当下做局部最优判断**
* **回溯：能够回退**
* **动态规划：最优判断 + 回退**

## 二分查找模板

```java
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return -1;
}
```
