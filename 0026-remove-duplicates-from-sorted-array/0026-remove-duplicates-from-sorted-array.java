class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int i = 1; // Start from the second element
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j-1]) { // If the current element is not equal to the previous one
                nums[i] = nums[j]; // Place it at the first unoccupied position
                i++; // Increment the position for the next unique element
            }
        }
        return i; // The new length of the array without duplicates
    }
}
