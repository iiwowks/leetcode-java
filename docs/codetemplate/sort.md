# sort

## 快速排序
![image-quickSort](../assets/quickSort.gif)
```python
from typing import List

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        size = len(nums)
        self.__quick_sort(nums, 0, size - 1)
        return nums

    def __quick_sort(self, nums, left, right):
        if left >= right:
            return
        p_index = self.__partition(nums, left, right)
        self.__quick_sort(nums, left, p_index - 1)
        self.__quick_sort(nums, p_index + 1, right)

    def __partition(self, nums, left, right):
        pivot = nums[left]
        # [left + 1, lt] < pivot
        # [lt + 1, i) >= pivot

        lt = left
        for i in range(left + 1, right + 1):
            if nums[i] < pivot:
                lt += 1
                nums[lt], nums[i] = nums[i], nums[lt]
        nums[lt], nums[left] = nums[left], nums[lt]
        return lt
```

## 归并排序
```python
from typing import List

class Solution:

    def sortArray(self, nums: List[int]) -> List[int]:
        size = len(nums)
        temp = [0 for _ in range(size)]
        self.__merge_sort(nums, 0, size - 1, temp)
        return nums

    def __merge_sort(self, nums, left, right, temp):
        if left == right:
            return
        mid = (left + right) >> 1

        self.__merge_sort(nums, left, mid, temp)
        self.__merge_sort(nums, mid + 1, right, temp)
        self.__merge_of_two_sorted_array(nums, left, mid, right, temp)

    def __merge_of_two_sorted_array(self, nums, left, mid, right, temp):
        # [left, mid] 有序
        # [mid + 1, right] 有序
        for i in range(left, right + 1):
            temp[i] = nums[i]

        i = left
        j = mid + 1
        for k in range(left, right + 1):
            if i == mid + 1:
                nums[k] = temp[j]
                j += 1
            elif j == right + 1:
                nums[k] = temp[i]
                i += 1
            elif temp[i] <= temp[j]:
                nums[k] = temp[i]
                i += 1
            else:
                nums[k] = temp[j]
                j += 1
```

## 选择排序
```python
from typing import List

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        size = len(nums)

        for i in range(size - 1):
            min_index = i
            for j in range(i + 1, size):
                if nums[j] < nums[min_index]:
                    min_index = j
            nums[i], nums[min_index] = nums[min_index], nums[i]
        return nums
```

## 插入排序
![](../assets/insertionSort.png)
```python
from typing import List

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        size = len(nums)
        for i in range(1, size):
            temp = nums[i]
            j = i
            while j > 0:
                if nums[j - 1] > temp:
                    nums[j] = nums[j - 1]
                else:
                    break
                j -= 1
            nums[j] = temp
        return nums
```

## 计数排序
```python
from typing import List

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        size = len(nums)

        temp = nums[:]

        # 根据每个元素值的范围
        # -50000 <= A[i] <= 50000
        M = 100000
        counter = [0] * M

        for num in temp:
            counter[num + 50000] += 1

        # 变成前缀和数组
        for i in range(1, M):
            counter[i] += counter[i - 1]

        # 从后向前赋值回去
        for i in range(size - 1, - 1, -1):
            counter[temp[i] + 50000] -= 1
            nums[counter[temp[i] + 50000]] = temp[i]
        return nums
```