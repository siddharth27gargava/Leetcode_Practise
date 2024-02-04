class Solution {
    public void rotate(int[] nums, int k) {
       
       int n = nums.length;
       int i = 0;
       
       //4,5,1,2,3
       int[] res = new int[nums.length];

       // use concept of places : (i+k) % n and in index value, put ith value

       while (i < res.length) {
           int places = (i+k) % n;
           res[places] = nums[i];
           i++;
       }

       for (int j = 0; j < res.length; j++) {
           nums[j] = res[j];
       }
    }
}