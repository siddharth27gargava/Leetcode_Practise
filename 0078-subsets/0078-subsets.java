class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        generate(0,res, new ArrayList(), nums);
        return res;
    }
    
    public void generate(int idx, List<List<Integer>> res, List<Integer> curr, int[] nums){
        if(idx == nums.length){
            res.add(new ArrayList(curr));
            return;
        }
        
        curr.add(nums[idx]);
        generate(idx+1,res,curr,nums);
        curr.remove(curr.size() - 1);
        
        generate(idx + 1, res, curr, nums);
    }
    
}