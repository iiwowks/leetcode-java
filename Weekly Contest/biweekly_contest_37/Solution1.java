/**
 * [5122. 删除某些元素后的数组均值]
 * 
 */

class Solution1 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int num = arr.length / 20;
        int left = num, sum = 0;

        while (left <= arr.length - num - 1) {
            sum += arr[left];
            left++;
        }
        return (double) sum / (arr.length - 2 * num);
    }
}
