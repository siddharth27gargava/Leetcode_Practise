class Solution {
    public int removeDuplicates(int[] nums) {
        //count the number of duplicates
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            int count = 1;
            while (r < nums.length - 1 && nums[r] == nums[r+1]) {
                count++;
                r++;
            }

            for (int i = 0; i < Math.min(2, count); i++) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }

        return l;
    }
}