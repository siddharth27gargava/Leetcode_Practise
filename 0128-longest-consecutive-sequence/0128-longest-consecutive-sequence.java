class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int count = 0;
        int max = 0;

        for(int num : nums){
            if (!set.contains(num - 1)) {
                count = 1;
                while (set.contains(num + 1)) {
                    count++;
                    num++;
                }
                max = Math.max(count, max);
            }
        }

        return max;
    }
}