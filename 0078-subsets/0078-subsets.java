class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        recursion(res, new ArrayList<>(), 0, nums);

        return res;
    }

    //O(n) - time
    //O(n) - space

    public void recursion(List<List<Integer>> res, List<Integer> curr, int idx, int[] nums){
        if (idx == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        //include
        curr.add(nums[idx]);
        recursion(res, curr, idx + 1, nums);

        //exclude
        curr.remove(curr.size() - 1);
        recursion(res, curr, idx + 1, nums);
    }
}