class Solution {
    public void sortColors(int[] nums) {
        //in-place sorting

        for (int i = 0; i < nums.length; i++) {
            int correct = nums[i];

            if (nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
                i--;
            }
        }

    }
}