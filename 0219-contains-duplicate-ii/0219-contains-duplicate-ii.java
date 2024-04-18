class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        //check if window size is greater than k, then remove
        //check if any common element return true
        //keep expanding right in end
        HashSet<Integer> window = new HashSet<>();

        int right = 0;

        while(right < nums.length){

            if (window.size() > k) {
                window.remove(nums[left]);
                left++;
            }

            if (window.contains(nums[right])) {
                return true;
            }

            
            window.add(nums[right]);
            right++;
        }

        return false;
    }
}