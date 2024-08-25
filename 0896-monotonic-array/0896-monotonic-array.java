class Solution {
    public boolean isMonotonic(int[] nums) {
        //Use a singlepass check
        if(nums.length <= 2){
            return true;
        }

        int direction = 0;

        for(int i = 0; i < nums.length - 1; i++){
            if (nums[i] < nums[i+1]) {
                if (direction == 0) {
                    direction = 1;
                } else if (direction == -1) {
                    return false;
                }
            } else if (nums[i] > nums[i+1]) {
                if (direction == 0) {
                    direction = -1;
                } else if (direction == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}