class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        //O(1) lookup time
        for (int num : nums) {
            set.add(num);
        }
        //1,3,2
        //6,5,4,1,7,3
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int count = 1;
                while (set.contains(nums[i] + 1)) {
                    count++;
                    nums[i]++;
                }
                max = Math.max(count, max);
            }
        }

        return max;

    }
}