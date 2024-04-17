class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        //1. findidx_innumtwo
        //2. find greater nextGreater

        int[] res = new int[nums1.length];

        for (int i = 0; i < res.length; i++) {
            int idx = findindex_numtwo(nums2, nums1[i]);
            int gr = nextGreater(nums2, idx);

            res[i] = gr;
        }

        return res;

    }

    public int findindex_numtwo(int[] nums, int item){
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == item) {
                return i;
            }
        }

        return -1;
    }

    public int nextGreater(int[] nums, int idx){
        int max = nums[idx];
        for (int i = idx+1; i < nums.length; i++) {
            if (nums[i] > max) {
                return nums[i];
            }
        }
        return -1;
    }
}