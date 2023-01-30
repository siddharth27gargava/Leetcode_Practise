class Solution {
    public int findMin(int[] nums) {
       if(nums.length == 0){
            return -1;
        }

        int ans = -1;
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
        
        ans = nums[left];
        return ans;
    }
}