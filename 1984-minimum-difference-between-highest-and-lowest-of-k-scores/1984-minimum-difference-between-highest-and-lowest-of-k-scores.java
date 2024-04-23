class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        if (k == 1) {
            return 0;
        }
        int left = 0;
        int right = k - 1;
        int min = Integer.MAX_VALUE;
        
        while(right < nums.length){
            min = Math.min(min, nums[right] - nums[left]);
            left++;
            right++;
        }

        return min;
        
    }

    public int findLowest(int[] nums){
        int min = Integer.MAX_VALUE;

        for(int num : nums){
            min = Math.min(min, num);
        }

        return min;
    }
}