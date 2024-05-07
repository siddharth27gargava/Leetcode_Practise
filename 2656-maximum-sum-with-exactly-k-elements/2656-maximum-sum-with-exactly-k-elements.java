class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        //max, max+1, max+2
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += max;
            max = max + 1;
        }

        return sum;   
    }
}