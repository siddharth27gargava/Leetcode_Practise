class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        // int count = 0;
        int sum = 0;

        while (right < nums.length) {

            sum = sum + nums[right];

            while (sum >= target) {
                min = Math.min(right - left + 1, min);
                sum = sum - nums[left];
                left++;
            }

            right++;
        }

        if(min == Integer.MAX_VALUE){
            return 0;
        }

        return min;
    }
}