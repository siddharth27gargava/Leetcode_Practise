class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int count = 0;
        while(nums[nums.length - 1] > 0){
            if(nums[left] == 0){
                left++;
                continue;
            }

            int sub = nums[left];

            for (int i = left; i < nums.length; i++) {
                nums[i] = nums[i] - sub;
            }

            count++;

        }

        return count;
    }
}