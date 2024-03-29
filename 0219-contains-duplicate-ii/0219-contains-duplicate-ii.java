class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }

        int left = 0;
        HashSet<Integer> window = new HashSet<>();

        for(int right = 0; right < nums.length; right++){

            if (window.size() > k) {
                window.remove(nums[left]);
                left++;
            }

            if (window.contains(nums[right])) {
                return true;
            } 

            window.add(nums[right]);
        }

        return false;
    }
}