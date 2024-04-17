class Solution {
    public int pivotIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (sumLeft(nums,i) == sumRight(nums,i)) {
                return i;
            }
        }

        return -1;
    }

    public int sumLeft(int[] nums, int idx){
        int sum = 0;

        for (int i = 0; i < idx; i++) {
            sum = sum + nums[i];
        }

        return sum;
    }

    public int sumRight(int[] nums, int idx){
        int sum = 0;

        for (int i = nums.length - 1; i > idx; i--) {
            sum = sum + nums[i];
        }

        return sum;
    }
}