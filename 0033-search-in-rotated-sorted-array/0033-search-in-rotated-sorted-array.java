class Solution {
    public int search(int[] nums, int target) {
        
        //find pivot
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
            int mp = (left+right)/2;
            
            if(nums[mp] > nums[right]){
                left = mp + 1;
            } else {
                right = mp;
            }
        }
        
        
        //find the array to search in
        int start = left;
        left = 0;
        right = nums.length - 1;
        if(nums[start] <= target && nums[right] >= target){
            left = start;
        } else {
            right = start;
        }
        
        //binary search
        while(left <= right){
            int mp = (left + right)/2;
            
            if(nums[mp] > target){
                right = mp-1;
            } else if(nums[mp] < target){
                left = mp+1;
            } else {
                return mp;
            }
        }
        
        return -1;
    }
}