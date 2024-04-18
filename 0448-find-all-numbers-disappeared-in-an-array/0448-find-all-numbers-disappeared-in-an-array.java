class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        //[4,3,2,7,8,2,3,1]
        for (int i = 0; i < nums.length; i++) {
            int correct = nums[i] - 1;
            //4 != 7
            if (nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
                i--;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if (nums[i] - 1 != i) {
                res.add(i+1);
            }
        }

        return res;
    }
}