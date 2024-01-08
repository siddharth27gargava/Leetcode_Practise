class Solution {
    public int[] productExceptSelf(int[] nums) {
        //Logic is that
        //[1,2,3,4]
        //[1,1,2,6]
        //[24,12,4,1]
        
        int[] larr = new int[nums.length];
        larr[0] = 1;
        int lprod = 1;
        for(int i = 1; i < larr.length; i++){
            lprod = lprod * nums[i-1];
            larr[i] = lprod;
        }

        int[] rarr = new int[nums.length];
        rarr[nums.length - 1] = 1;
        int rprod = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            rprod = rprod * nums[i+1];
            rarr[i] = rprod;
        }

        int[] ans = new int[nums.length];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = larr[i] * rarr[i];
        }

        return ans;
    }
}