class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        helper(0, nums, new ArrayList<>(), ans);

        return ans;
    }

    public void helper(int idx, int[] nums, List<Integer> curr, List<List<Integer>> ans){
        if(idx == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[idx]);
        helper(idx+1,nums,curr,ans);

        curr.remove(curr.size() - 1);
        helper(idx + 1, nums, curr, ans);
    }
}