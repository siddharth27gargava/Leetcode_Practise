class Solution {
    public void moveZeroes(int[] nums) {
        //O(n) - time, Space - O(1)
        int left = 0;

        //logic is that traverse and find all non zeroes and keep swapping with left while also increasing left
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            
        }


    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}