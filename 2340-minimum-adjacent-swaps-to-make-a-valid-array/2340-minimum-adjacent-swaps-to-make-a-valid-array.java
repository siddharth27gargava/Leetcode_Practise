class Solution {
    public int minimumSwaps(int[] nums) {
        int minindex = 0;
        int maxindex = 0;

        for (int i = 0; i < nums.length; i++) {
            if((nums[i] < nums[minindex]) || (nums[i] == nums[minindex] && minindex > i)){
                minindex = i;
            }

            if((nums[i] > nums[maxindex]) || (nums[i] == nums[maxindex] && maxindex < i)){
                maxindex = i;
            }
        }

        if(minindex == maxindex){
            return 0;
        }

        int swap = (nums.length - 1) - maxindex + minindex - (minindex > maxindex ? 1 : 0);

        return swap;
    }
}