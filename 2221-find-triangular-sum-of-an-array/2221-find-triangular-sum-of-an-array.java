class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        boolean[] visit = new boolean[n];

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return nums[0];
        }

        while (n > 1) {
            int i;
            for (i = n - 1; i > 0; i--) {
                nums[i] = (nums[i - 1] + nums[i]) % 10;
            }
            shiftbyone(nums);
            n--;
        }

        return nums[0];
    }

    public void shiftbyone(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = nums[i+1];
        }

        nums[nums.length - 1] = 0;
    }
}