class Solution {
    public int search(int[] nums, int target) {
         if (nums.length == 0 || nums == null){
            return -1;
        }
        //Find pivot point
        int left = 0;
        int right = nums.length - 1;
        while (right > left){
            int mp = left + (right - left)/2;
            if (nums[mp] > nums[right]){
                left = mp + 1;
            } else {
                right = mp;
            }
        }

        int start = left;
        left = 0;
        right = nums.length - 1;

        //Find which sub-array to search in
            if (nums[start] <= target && nums[right] >= target){
                left = start;
            } else {
                right = start;
            }
        
        
        //Normal binary search
        while (left <= right){
            int hp = left + (right - left)/2;

            if (nums[hp] > target){
                right = hp - 1;
            } else if(nums[hp] < target){
                left = hp + 1;
            } else {
                return hp;
            }
        }

        return -1;
    }
}