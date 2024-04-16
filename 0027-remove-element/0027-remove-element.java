class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int boundary = nums.length - 1;

        while(i <= boundary){
            if(nums[i] == val){
                swap(nums, i, boundary);
                boundary--;
            } else {
                i++;
            }
        }

        return i; 
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}