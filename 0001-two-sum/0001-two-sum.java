class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == val) {
                    res.add(i);
                    res.add(j);
                }
            }
        }
        int[] ans = new int[2];
        for (int i = 0; i < res.size(); i++) {
            ans[0] = res.get(0);
            ans[1] = res.get(1);
        }

        return ans;
    }
}