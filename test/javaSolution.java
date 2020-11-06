public class javaSolution {
    // put function below
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                // put ahead
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                
                count++;
            }
        }
        return nums.length - count;
    }

    // write test case here
    public static void main(String[] args) {
        javaSolution solution = new javaSolution();
        int res = solution.removeElement(new int[]{3,2,2,3}, 3);
        System.out.println(res);
    }
}
