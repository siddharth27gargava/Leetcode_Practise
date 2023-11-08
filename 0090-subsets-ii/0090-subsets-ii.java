class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        
        helper(0, nums, res, new ArrayList<>());
        
        return res;
    }
    
    public void helper(int idx, int[] nums, List<List<Integer>> res, List<Integer> curr){
        //Base Case
        if(idx == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        //Include
        curr.add(nums[idx]);
        helper(idx + 1, nums, res, curr);
        
        //Duplicate remove
        while(idx + 1 < nums.length && nums[idx] == nums[idx + 1]){
            idx++;
        }
        
        //Exclude
        curr.remove(curr.size() - 1);
        helper(idx + 1, nums, res, curr);
    }
}